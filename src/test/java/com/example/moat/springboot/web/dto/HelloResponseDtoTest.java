package com.example.moat.springboot.web.dto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class HelloResponseDtoTest {
    @Test
    public void 룸복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);          //assertThat : assertj라는 테스트 검증 라이브러리의 검증 메소드. 대상을 메소드 인자로 받음. 메소드 체이닝이 되기 때문에 같은 메소드 이어서 작성 가능
        assertThat(dto.getAmount()).isEqualTo(amount);      //isEqualTo : 동등비교 메소드. 이 경우 assertThat의 dto.getAmount와 amount가 같아야 성공
    }
}


// 해당 소스코드에서는 JUnit의 기본 assertThat이 아니라 assertj의 assertThat을 사용했다.
// CoreMatchers와 다르게 추가적인 라이브러리가 필요하지 않다.
// 자동완성이 좀더 확실하게 지원된다.