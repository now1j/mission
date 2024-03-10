package com.zb.mission.controller;

import com.zb.mission.entity.Store;
import com.zb.mission.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")      //모든 요청이 '/stores' 경로로 매핑되도록 함
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {     //의존성 주입
        this.storeService = storeService;
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return ResponseEntity.ok(storeService.createStore(store));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable int id) {
        return ResponseEntity.ok(storeService.getStoreById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable int id, @RequestBody Store store) {
        store.setId(id);
        return ResponseEntity.ok(storeService.updateStore(store));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();  //204 상태 코드는 요청이 성공적으로 처리되었으나 클라이언트에 반환할 콘텐츠가 없을 때 사용
    }

    // 유저: 전체 매장 조회
    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        List<Store> stores = storeService.getAllStores();
        return ResponseEntity.ok(stores);
    }

    // 유저: 매장명으로 조회
    @GetMapping("/searchByName")
    public ResponseEntity<List<Store>> searchStoresByName(@RequestParam String name) {
        List<Store> stores = storeService.searchStoresByName(name);
        return ResponseEntity.ok(stores);
    }

    // 유저: 위치로 조회
    @GetMapping("/searchByLocation")
    public ResponseEntity<List<Store>> searchStoresByLocation(@RequestParam String location) {
        List<Store> stores = storeService.searchStoresByLocation(location);
        return ResponseEntity.ok(stores);
    }

    // 유저: 예약 가능 여부로 조회
    @GetMapping("/searchByAvailability")
    public ResponseEntity<List<Store>> searchStoresByAvailability(@RequestParam boolean available) {
        List<Store> stores = storeService.searchStoresByAvailability(available);
        return ResponseEntity.ok(stores);
    }
}
