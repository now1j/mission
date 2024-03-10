package com.zb.mission.controller;


import com.zb.mission.entity.Reservation;
import com.zb.mission.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // 예약 생성
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        Reservation newReservation = reservationService.createReservation(reservation);
        return ResponseEntity.ok(newReservation);
    }

    // 특정 매장의 모든 예약 조회
    @GetMapping("/store")
    public ResponseEntity<List<Reservation>> getStoreReservations(@RequestParam String storeName) {
        List<Reservation> storeReservations = reservationService.getStoreReservations(storeName);
        return ResponseEntity.ok(storeReservations);
    }

    // 특정 예약 상세 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        Reservation reservation = reservationService.getReservationById(id);
        return ResponseEntity.ok(reservation);
    }

    // 예약 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable int id) {
        reservationService.deleteReservationById(id);
        return ResponseEntity.noContent().build();
    }
}