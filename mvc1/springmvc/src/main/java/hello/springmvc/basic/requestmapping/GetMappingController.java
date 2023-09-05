package hello.springmvc.basic.requestmapping;

import hello.springmvc.basic.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GetMappingController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    //Get - 기본
    @GetMapping("/home")
    public String newForm() {return "home";}


    //Get 다중호출
    @GetMapping({"/home-stay", "/home-go"})
    public String helloBasic() {return "home";}


    //@RequestParam : 기본설정
    @ResponseBody
    @GetMapping("/request-param-basic")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }


    //@RequestParam : 파라미터를 Map으로 조회
    @ResponseBody
    @GetMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }


    //속성값 설정
    @ResponseBody
    @RequestMapping("/request-param-v22")
    public String requestParamTwo(@RequestParam("username") String memberName, @RequestParam("age") int memberAge){
        log.info("username={}, age={}", memberName, memberAge);
        return "OK";
    }

    //@RequestParam : required는 필수 값, defaultValue는 기본 값
    @ResponseBody
    @GetMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    //단일 PathVariable
    @ResponseBody
    @GetMapping("/mappings/{data}")
    public String mappingPath(@PathVariable String data) {
        log.info("mappingPath userId={}", data);
        return "ok" + data;
    }

    //다중 PathVariable
    @ResponseBody
    @GetMapping("/mappings/{data}/{id}")
    public String mappingPath3(@PathVariable String data, @PathVariable("id") int num) {
        log.info("mappingPath userId={} {}", data, num);
        return "ok";
    }

    //Model에 객체/리스트/해시 넣기
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

        return "basic/variable";
    }

    //Model에 객체/리스트/해시 넣기
    @GetMapping("/variable11")
    public String variable11(@RequestParam String username,
                                @RequestParam int age,
                                Model model) {
        User userA = new User(username, age);
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

        System.out.println(userA.toString());
        System.out.println(userB.toString());

        return "basic/variable";
    }

    //Model에 객체/리스트/해시 넣기
    @GetMapping("/variabl111")
    public String variable111(@ModelAttribute User user) {
        System.out.println(user.toString());
        return "basic/variable";
    }

    //json으로 응답하기
    @ResponseBody
    @RequestMapping("/hello-go2")
    public String helloBasic2() {return "ok";}
}
