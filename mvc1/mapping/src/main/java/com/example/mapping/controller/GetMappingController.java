package com.example.mapping.controller;

import com.example.mapping.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class GetMappingController {

    //기본 URL 호출
    @ResponseBody
    @GetMapping("/home")
    public String newForm() {
        return "newForm";
    }


    //다중 URL 호출
    @ResponseBody
    @GetMapping({"/home-stay", "/home-go"})
    public String helloBasic() {
        return "helloBasic";
    }


    //기본형을 요청 파라미터로 입력
    @ResponseBody
    @GetMapping("/request-param-basic")
    public String requestParamBasic(@RequestParam String username,
                                    @RequestParam int age) {
        log.info("username={}, age={}", username, age);
        return "requestParamV3";
    }


    //기본형을 여러개 요청 파라미터로 입력
    @ResponseBody
    @GetMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}, gender={}", paramMap.get("username"), paramMap.get("age"), paramMap.get("gender"));
        return "requestParamMap";
    }


    //입력값하고 저장되는 변수가 다른 요청 파라미터로 입력
    @ResponseBody
    @GetMapping("/request-param-variable")
    public String requestParamVariable(@RequestParam("username") String memberName, @RequestParam("age") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);
        return "requestParamAnotherVariable";
    }


    //입력 유/무, 기본값을 설정하는 요청 파라미터로 입력
    @ResponseBody
    @GetMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {
        log.info("username={}, age={}", username, age);
        return "requestParamDefault";
    }


    //URI 경로에 따라 변경되는 요청 파라미터로 입력
    @ResponseBody
    @GetMapping("/mappings/{data}")
    public String mappingPath(@PathVariable String data) {
        log.info("mappingPath userId={}", data);
        return "mappingPath";
    }


    //다중 URI 경로에 따라 변경되는 요청 파라미터로 입력
    @ResponseBody
    @GetMapping("/mappings/{data}/{id}")
    public String mappingPathTwo(@PathVariable String data, @PathVariable("id") int num) {
        log.info("mappingPath userId={} {}", data, num);
        return "mappingPathTwo";
    }


    //입력 X, view에 값 넘겨주기
    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        log.info("User username={}, age={}", userA.getUsername(), userA.getAge());
        log.info("User username={}, age={}", userB.getUsername(), userB.getAge());
        return "basic/variable";
    }


    //기본형 요청 파라미터로 view에 값 넘겨주기
    @GetMapping("/variable-input")
    public String variableInput(@RequestParam String username,
                                @RequestParam int age,
                                Model model) {
        User userA = new User(username, age);
        model.addAttribute("user", userA);

        log.info("User username={}, age={}", userA.getUsername(), userA.getAge());

        return "basic/variableEasy";
    }


    //객체형 요청 파라미터로 view에 값 넘겨주기
    @GetMapping("/variable-object")
    public String variableObject(@ModelAttribute User user,
                                 Model model) {

        model.addAttribute("user", user);
        log.info("User username={}, age={}", user.getUsername(), user.getAge());

        return "basic/variableEasy";
    }

    //view 반환
    @GetMapping("/newHome")
    public String newHome() {return "newHome";}

    //json 반환
    @ResponseBody
    @RequestMapping("/newHello-go")
    public String newGoHome() {return "newHello-go";}
}
