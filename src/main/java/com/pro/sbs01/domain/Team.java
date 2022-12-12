package com.pro.sbs01.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
// @Entity : 기본생성자, getter 메서드 고유키 @Id 반드시 가져야한다.  
@Entity(name = "TEAMS") // 엔터티 클래스와 데이터베이스 테이블의 이름이 다르면 반드시 name 속성을 지정.
@SequenceGenerator(name = "TEAMS_SEQ_GEN", sequenceName = "TEAMS_SEQ", 
                initialValue = 1, allocationSize = 1)
//-> 오라클의 시퀀스 객체를 고유키 생성에 사용하기 위해서.
@EqualsAndHashCode
public class Team extends BaseTimeEntity {
    // field
    @Id
    @Column(nullable = false, name = "team_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAMS_SEQ_GEN")
    private Integer teamId;
    
    @Column(nullable = false, name = "team_name")
    private String teamName;
    
    @Column(nullable = false, name = "team_password")
    private String teamPassword;
    
    @Column(nullable = false)
    private String purpose;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
    @Column(nullable = false, name = "category_id")
    private Integer categoryId;
    
    @Column(nullable = false, name = "team_max")
    private Integer teamMax;
    
    public Team(String teamName, String category) {
        this();
    }
    
}