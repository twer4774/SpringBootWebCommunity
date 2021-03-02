package walter.SpringBootCommunityWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import walter.SpringBootCommunityWeb.annotation.SocialUser;
import walter.SpringBootCommunityWeb.domain.User;

/**
 * 인증된 User 정보를 세션에 저장해주는 기능 생성
 */

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginView(){
        return "login";
    }

    /*@GetMapping(value = "/{facebook|google|kakao}/complete")
    public String loginComplete(HttpSession session){
        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        Map<String, String> map = (HashMap<String, String>) authentication.getUserAuthentication().getDetails();
        session.setAttribute("user", User.builder()
                .name(map.get("name"))
                .email(map.get("email"))
                .pincipal(map.get("id"))
                .socialType(SocialType.FACEBOOK)
                .createdDate(LocalDateTime.now())
                .build());

        return "redirect:/board/list";
    }*/

    //위의 코드를 AOP를 사용해 리팩토링 - HandlerMethodArgumentResolver 인터페이스를 구혆하는 @SocialUSer 이용
    @GetMapping(value = "/loginSuccess")
    public String loginComplete(){
        return "redirect:/board/list";
    }
}
