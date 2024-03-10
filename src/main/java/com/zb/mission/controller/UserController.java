package com.zb.mission.controller;

import com.zb.mission.entity.Store;
import com.zb.mission.entity.User;
import com.zb.mission.service.StoreService;
import com.zb.mission.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 사용자 등록
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    // 사용자 정보 조회
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // 사용자 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.leaveUser(userId);
        return ResponseEntity.noContent().build();
    }
}