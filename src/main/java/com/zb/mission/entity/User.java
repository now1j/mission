package com.zb.mission.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userId;
    private String userPw;
    @Email
    private String userEmail;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
}
