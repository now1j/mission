package com.zb.mission.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Partners")
public class Partner {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String partnerId;
    private String partnerPw;
    @Email
    private String partnerEmail;

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
