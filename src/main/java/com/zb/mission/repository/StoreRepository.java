package com.zb.mission.repository;

import com.zb.mission.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    //JpaRepository 인터페이스를 확장하여 CRUD 작업을 위한 기본적인 메서드들을 자동으로 사용 가능

    //사용자 정의 메서드: 레포지토리에 추가적인 정의 필요
    List<Store> findByName(String name);
    List<Store> findByLocation(String location);
    List<Store> findByReservationAvailability(boolean available);
}
