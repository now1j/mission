package com.zb.mission.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;    //예약한 매장

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;      //예약한 유저

    private LocalDateTime reservationTime;
    private LocalDate reservationDate;


}
