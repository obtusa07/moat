package com.example.moat.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)        //테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다. SpringRunner를 실행시킴
@WebMvcTest(controllers = HelloController.class) //Web에 집중할 수 잇는 어노테이션. @Controller, @ControllerAdvice 등은 사용 못 함
public class HelloControllerTest {

    @Autowired          //스프링이 관리하는 빈을 주입받음
    private MockMvc mvc;        //웹 API(HTTP GET, POST) 시험할때 사용

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))  //체이닝이 지원되어 아래의 검증 기능을 이어서 선언 가능
                .andExpect(status().isOk())   //HTTP Header의 Status(200,404,500)을 검증하는데 여기선 OK인 200번인지 확인한다.
                .andExpect(content().string(hello));    //응답 본문의 내용을 검증한다. 컨트롤러에서는 "hello"를 리턴하도록 했는데 맞는지 확인한다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name)
                                               .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
