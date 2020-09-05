package cadispring.exercisespring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    //MVC 모뎅
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API
    @GetMapping("hello-string")
    @ResponseBody //http에서 body부에 데이터를 직접 넣어주겠다.  (html 태그 없이 문자가 그대로.)
    public String helloString(@RequestParam("name") String name) {
        return "hellp"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //json 방식
    }

    //프로퍼티 접근 방식. getter, setter
    static class Hello {
        private String name;
        public String getName(){
            return name;

        }

        public void setName(String name)
        {
            this.name = name;
        }
    }
}

