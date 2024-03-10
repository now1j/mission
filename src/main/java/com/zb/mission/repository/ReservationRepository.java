package com.zb.mission.repository;

import com.zb.mission.entity.Reservation;
import com.zb.mission.entity.Store;
import com.zb.mission.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserId(User user);
    List<Reservation> findByStoreName(String name);

}
