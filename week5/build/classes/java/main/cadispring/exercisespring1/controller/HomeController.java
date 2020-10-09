package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // dom의 첫번째. 즉 localhost에서 기본-> localhost://로 들어가면 실행되는 함수
    public String home() {
        return "home";
    }
}