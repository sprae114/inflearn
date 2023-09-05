package corespring.corespring.member;

import lombok.Getter;
import lombok.Setter;

//파일 생성할때 대문자로 시작하기
//@RequiredArgsConstructor은 final 붙은것
@Getter
@Setter
public class Member {
    private Long Id;
    private String name;
    private Grade grade;

    public Member(Long Id, String name, Grade grade){    //생성자는 반환타입 X
        this.Id = Id;
        this.name = name;
        this.grade = grade;
    }
}


