package image.upload.uploadtest.service.refresh;

import image.upload.uploadtest.entity.RefreshEntity;
import image.upload.uploadtest.repository.refresh.RefreshRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RefreshService {

    private final RefreshRepository refreshRepository;

    public void reissue(String refresh, String username,String newRefresh){

        //토큰이 존재하는지 확인
        Boolean isExist = refreshRepository.existsByRefresh(refresh);
        if(!isExist){
            throw new NoSuchElementException("토큰이 존재하지 않습니다.");
        }

        // 기존에 있던 리프레시 토큰을 삭제
        refreshRepository.deleteByRefresh(refresh);

        //존재한다면 로직 실행
        Date date = new Date(System.currentTimeMillis() + 86400000L);
        RefreshEntity refreshEntity = new RefreshEntity(username, newRefresh, date.toString());
        refreshRepository.save(refreshEntity);
        // 리프레시 토큰의 정보를 db에 저장
    }
}
