package image.upload.uploadtest;

import image.upload.uploadtest.dto.item.ItemRegisterRequest;
import image.upload.uploadtest.dto.member.join.JoinRequest;
import image.upload.uploadtest.entity.Member;
import image.upload.uploadtest.repository.member.MemberRepository;
import image.upload.uploadtest.service.item.ItemService;
import image.upload.uploadtest.service.itemImage.ItemImageService;
import image.upload.uploadtest.service.member.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@RequiredArgsConstructor
@EnableWebMvc
public class UploadtestApplication {

	private final MemberService memberService;
	private final ItemService itemService;
	private final ItemImageService itemImageService;

	public static void main(String[] args) {
		SpringApplication.run(UploadtestApplication.class, args);
	}

	@PostConstruct
	public void init(){
		JoinRequest joinRequest = new JoinRequest("user", "1234", "1234", "user", "user@user.com");
		memberService.joinMember(joinRequest);

		JoinRequest joinRequest1 = new JoinRequest("user2","1234","1234","user2","user2@user2.com");
		memberService.joinMember(joinRequest1);

		for(int i=0; i<100; i++){
			ItemRegisterRequest itemRegisterRequest = new ItemRegisterRequest("item"+i,1000,100,"item"+1+"description");
			itemService.save("user",itemRegisterRequest);
		}



	}
}
