package com.example.mapping.controller;

import com.example.mapping.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class PostMappingController {

    //@RequestParam 로 변수 입력하는 경우
    @ResponseBody
    @PostMapping("/post-basic")
    public String postBasic(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("post-basic username = {}, age={}", username, age);
        return "post-basic username = " + username + " , " + age;
    }

    //@RequestParam 를 생략하여 사용하는 경우
    @ResponseBody
    @PostMapping("/requestBody-Basic")
    public String requestBodyBasic(String username,
                                   int age) {
        log.info("username={}, age={}", username, age);
        return "requestBody-Object username = " + username + " , " + age;
    }

/*    //@RequestBody 로 객체로 만드경우
    @ResponseBody
    @PostMapping("/requestBody-Basic2")
    public String requestBodyBasic2(@RequestBody String username,
                                    @RequestBody int age) {
        log.info("username={}, age={}", username, age);
        return "requestBody-Object2";
    }
    //URL X, Body X, JSON X*/

    //
    @ResponseBody
    @PostMapping("/requestBody-string")
    public String requestBodyString(String text) {
        log.info("text = {}", text);
        return "requestBody-string text = " + text;
    }

    @ResponseBody
    @PostMapping("/requestBody-string2")
    public String requestBodyString2(@RequestBody String text) {
        log.info("text = {}", text);
        return "requestBody-string2 text = " + text;
    }

    @ResponseBody
    @PostMapping("/requestBody-object")
    public String requestBodyObject(User user) {
        log.info("username={}, age={}", user.getUsername(), user.getAge());
        return "requestBody-object username = " + user.getUsername() + " , " + user.getAge();
    }

    @ResponseBody
    @PostMapping("/requestBody-object2")
    public String requestBodyObject2(@RequestBody User user) {
        log.info("username={}, age={}", user.getUsername(), user.getAge());
        return "requestBody-object2 username = " + user.getUsername() + " , " + user.getAge();
    }

}
