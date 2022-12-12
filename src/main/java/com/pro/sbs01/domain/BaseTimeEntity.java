package com.pro.sbs01.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass // 다른 엔터티 클래스들의 상위 클래스. 그니까 이거해야 다른 클래스에서 상속해서 컬럼으로 사용할 수 있게끔함 얘가 더 상위 클래스인거임 ㅇㅇ 
@EntityListeners(value = { AuditingEntityListener.class })
// -> 엔터티의 변화(생성,수정)가 생기면 동작하는 객체.
// -> 엔터티가 생성/수정되는 시간 정보를 테이블에 자동으로 기록하기 위해서.
// -> AuditingEntityListener를 활성화하기 위해서는 메인 클래스에서 설정이 필요.
public class BaseTimeEntity {
    
    @CreatedDate // 생성 날짜(시간)
    // 엔터티 클래스의 필드 이름은 자바의 관습(camel 표기법)으로 작성.
    // 테이블의 컬럼 이름은 데이터베이스의 관습(snake 표기법)으로 생성됨.
    @Column(name = "created_Time")
    private LocalDateTime createdTime;
    
    @LastModifiedDate // 최종 수정 날짜(시간)
    @Column(name = "modified_Time")
    private LocalDateTime modifiedTime;
    
    
    
}
