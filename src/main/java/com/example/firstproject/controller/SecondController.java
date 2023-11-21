package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/random-quote") // 1. url에 localhost:8080/random-quote를 입력한다.
    public String randomQuote(Model model){ /*  2. 요청받은 random-quote 뷰 에서는 Model로 부터 값을 전달받게 되는 데,
                                                   quotes 배열을 int로 형변환 한 random 함수에 의하여 무작위의 명언이
                                                   randomQuote.mustache에 노출된다.
                                                   (뷰페이지에는 attributeName인 {{randomQuote}}가 선언되어있다!
                                             */
        String[] quotes = {
                "행복은 습관이다. 그것을 몸에 지니라." +
                        "- 허버드 -",
                "고개 숙이지 마십시오. 세상을 똑바로 정면으로 " +
                        "바라보십시오. - 헬렌 켈러 - ",
                "고난의 시기에 동요하지 않는 것, 이것은 진정 " +
                        "칭찬받을만한 뛰어난 인물의 증거이다. - 베토벤 - ",
                "당신이 할 수 있다고 믿든 할 수 없다고 믿든 " +
                        "믿는 대로 될 것이다. - 헨리 포드 - ",
                "작은 기회로 부터 종종 위대한 업적이 시작된다. " +
                        " - 데모스테네스 - ",
                "난, 해적왕이 될거야!" +
                        " - 몽키 D 루피 -"
        };

        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[randInt]);

        return "randomQuote";
    }
}
