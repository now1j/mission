package com.zb.mission.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //클래스를 엔티티화
@Data   //클래스에 대한 getter, setter 메서드를 자동 생성
@NoArgsConstructor  //파라미터가 없는 기본 생성자를 자동으로 생성
@Table(name = "Stores")
public class Store {
    @Id //데이터베이스의 테이블을 기본키와 객체의 필드를 매핑하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 직접 할당하지 않고 데이터베이스가 할당하는 값 사용
    private int id;
    private String name;
    private String location;
    private String description;
    private boolean reservationAvailability;

    @OneToOne(mappedBy = "store")
    private Partner partner;


}
