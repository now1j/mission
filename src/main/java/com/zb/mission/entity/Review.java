package com.zb.mission.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;
    private int rating;

    // 리뷰 작성자
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 리뷰 대상 매장
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
