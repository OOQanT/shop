package image.upload.uploadtest.controller.refresh;

import image.upload.uploadtest.jwt.JWTUtil;
import image.upload.uploadtest.service.refresh.RefreshService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RefreshController {

    private final JWTUtil jwtUtil;
    private final RefreshService refreshService;

    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response){

        String refresh = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("refresh")){
                refresh = cookie.getValue();
            }
        }

        if(refresh == null){
            return new ResponseEntity<>("refresh token null", HttpStatus.BAD_REQUEST);
        }

        try{
            jwtUtil.isExpired(refresh);
        }catch (ExpiredJwtException e){
            return new ResponseEntity<>("refresh token expired", HttpStatus.BAD_REQUEST);
        }

        String category = jwtUtil.getCategory(refresh);

        if(!category.equals("refresh")){
            return new ResponseEntity<>("invalid refresh token",HttpStatus.BAD_REQUEST);
        }


        String username = jwtUtil.getUsername(refresh);
        String nickname = jwtUtil.getNickname(refresh);
        try{
            // 토큰이 db에 있는지 조회하고 있다면 기존 리프레시 토큰을 삭제 후 새로운 리프레시 토큰을 저장
            // 로직이 정상적으로 완료되었다면 새로운 토큰을 생성하여 response에 반환해 주어야 함

            // 새로운 토큰을 생성
            String newAccess = jwtUtil.createJwt("access",username, jwtUtil.getRole(refresh), nickname, 600000L );
            String newRefresh = jwtUtil.createJwt("refresh", username, jwtUtil.getRole(refresh), nickname, 68400000L );

            refreshService.reissue(refresh,username,newRefresh);

            //응답에 토큰을 반환
            response.setHeader("access", newAccess);
            response.addCookie(createCookie("refresh",newRefresh));

            return new ResponseEntity<>(HttpStatus.OK);

        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("토큰 정보가 존재하지 않습니다", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/token/validate")
    public ResponseEntity<?> token_validate(HttpServletRequest request, HttpServletResponse response){
        String accessToken = request.getHeader("access");
        Boolean expired = jwtUtil.isExpired(accessToken);
        if(!expired){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    private Cookie createCookie(String key, String value) {

        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24*60*60);
        //cookie.setSecure(true);
        //cookie.setPath("/");
        cookie.setHttpOnly(true);

        return cookie;
    }
}
