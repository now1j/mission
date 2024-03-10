package com.zb.mission.service;

import com.zb.mission.entity.Store;
import com.zb.mission.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    //생성자, 의존성 주입
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    //매장 등록: 새로운 매장 DB에 추가
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    //모든 매장 목록 조회
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    //특정 매장 상세 정보 조회
    public Store getStoreById(int id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID를 가진 매장을 찾을 수 없습니다."));
    }

    //매장 정보 업데이트
    public Store updateStore(Store store) {
        Store existingStore = storeRepository.findById(store.getId())
                .orElseThrow(() -> new RuntimeException("해당 ID를 가진 매장을 찾을 수 없습니다."));
        //필요한 필드 업데이트
        existingStore.setName(store.getName());
        existingStore.setLocation(store.getLocation());
        existingStore.setDescription(store.getDescription());
        return storeRepository.save(existingStore);
    }

    //매장 정보 삭제: 매장 id를 매개변수로 받아 해당 매장 삭제
    public void deleteStore(int id) {
        storeRepository.deleteById(id);
    }

    // 매장명으로 조회
    public List<Store> searchStoresByName(String name) {
        // StoreRepository를 사용하여 매장명에 해당하는 매장을 조회하는 코드
        return storeRepository.findByName(name);
    }

    // 위치로 조회
    public List<Store> searchStoresByLocation(String location) {
        // StoreRepository를 사용하여 위치에 해당하는 매장을 조회하는 코드
        return storeRepository.findByLocation(location);
    }

    // 예약 가능 여부로 조회
    public List<Store> searchStoresByAvailability(boolean available) {
        // StoreRepository를 사용하여 예약 가능 여부에 따라 매장을 조회하는 코드
        return storeRepository.findByReservationAvailability(available);
    }


}
