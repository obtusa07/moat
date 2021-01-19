package com.example.moat.springboot.web;

import com.example.moat.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController                     //JSON을 반환하는 컨트롤러로 만들어줌, 이걸 쓰면 @ResponseBody 를 각 메소드마다 선언했던걸 한번에 처리할수 있게 됨
public class HelloController {
    @GetMapping("/hello")        //HTML의 Get 요청을 받을 수 있는 API를 만들어줌. 이것이 @RequestMapping(method = RequestMethod.Get)으로 사용됐었던거임.
    public String hello(){          //hello로 요청이 오면 문자열 hello를 반환하는 기능
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }


}
