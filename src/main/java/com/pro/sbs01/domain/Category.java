package com.pro.sbs01.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity(name = "CATEGORYS")
@SequenceGenerator(name = "CATEGORYS_SEQ_GEN", sequenceName = "CATEGORYS_SEQ", 
                initialValue = 1, allocationSize = 1)
@EqualsAndHashCode
public class Category {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORYS_SEQ_GEN")
    @Column(nullable = false, name = "category_id")
    private Integer categoryId;
    
    
    @Column(nullable = false, name = "category_name")
    private String categoryName;
    
    public Category(String categoryName) {
        this(null, categoryName);
    }
    
    
}
