package com.zb.mission.service;

import com.zb.mission.entity.Partner;
import com.zb.mission.entity.User;
import com.zb.mission.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //유저 가입
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    //모든 유저 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //특정 유저 조회
    public User getUserById(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("해당 userId를 가진 유저를 찾을 수 없습니다."));
    }

    //유저 탈퇴
    public void leaveUser(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("해당 userId를 가진 유저를 찾을 수 없습니다."));
        userRepository.delete(user);
    }
}
