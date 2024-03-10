package com.zb.mission.service;

import com.zb.mission.entity.Reservation;
import com.zb.mission.entity.User;
import com.zb.mission.repository.ReservationRepository;
import com.zb.mission.repository.StoreRepository;
import com.zb.mission.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    public ReservationService(ReservationRepository reservationRepository, StoreRepository storeRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
    }

    // 예약 생성
    public Reservation createReservation(Reservation reservation) {
        // 예약 시간이 현재 시간으로부터 최소 10분 후인지 확인
        LocalDateTime now = LocalDateTime.now();
        if (reservation.getReservationTime().isAfter(now.plusMinutes(10))) {
            return reservationRepository.save(reservation);
        } else {
            throw new IllegalArgumentException("예약은 최소 10분 전부터 가능합니다.");
        }
    }

    // 특정 매장의 모든 예약 조회
    public List<Reservation> getStoreReservations(String storeName) {
        return reservationRepository.findByStoreName(storeName);
    }

    // 특정 유저 예약 조회
    public List<Reservation> getUserReservations(User userId) {
        return reservationRepository.findByUserId(userId);
    }


    // 특정 예약 상세 정보 조회
    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID를 가진 예약을 찾을 수 없습니다."));
    }


    // 예약 삭제
    public void deleteReservationById(int id) {
        reservationRepository.deleteById(id);
    }
}