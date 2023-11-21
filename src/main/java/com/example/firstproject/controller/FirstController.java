package com.example.firstproject.controller;


import jakarta.persistence.GeneratedValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// 모델 패키지 자동 임포트
import org.springframework.web.bind.annotation.GetMapping;
// 컨트롤러 선언과 동시에 자동으로 임포트된다.

@Controller  //컨트롤러임을 선언한다.
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "귀염둥이");
        return "greetings";

        /* /hi의 실행 흐름 : 1. @Controller 어노테이션을 통하여 이 클래스가 컨트롤러임을 선언
                           2. 클라이언트로부터 /hi라는 요청을 받아 접수. (localhost:8080/hi url 입력..!)
                           3. hi라는 요청을 받음과 동시에 niceToMeetYou 메서드를 수행.
                           4. 뷰 템플릿 페이지에서 사용할 변수를 등록하기 위해 모델 객체를 매개변수로 가져옴
                              (model.addAttribute에서 "username"은 뷰 템플릿쪽에서 쓰이는 매개변수명,
                               옆의 attributeValue는 뷰 템플릿으로부터 보이게 되는 값이다!
                               그래서 뷰에서는 username이 아닌 귀염둥이가 보인다~)
                           5. 메서드 수행 결과로 return에 적혀있는 템플릿 페이지를 반환하여 웹 브라우저로 전송한다.
         */
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","사랑둥이");
        return "goodbye";
    }
}
