package com.bjit.userservice.service.impl;

import com.bjit.userservice.entity.UserEntity;
import com.bjit.userservice.model.UserRequestModel;
import com.bjit.userservice.model.UserResponseModel;
import com.bjit.userservice.repository.UserRepository;
import com.bjit.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Object> create(UserRequestModel userRequestModel) {
        UserEntity userEntity = UserEntity.builder()
                .userName(userRequestModel.getUserName())
                .userBalance(userRequestModel.getUserBalance())
                .userOrder(userRequestModel.getUserOrder())
                .build();

        UserEntity savedUserEntity = userRepository.save(userEntity);
        return new ResponseEntity<>(savedUserEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> showAll() {
        List<UserEntity> userList = userRepository.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> delete(Long userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity != null) {
            userRepository.delete(userEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> updateUserEntity(Long userId, UserRequestModel userRequestModel) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity != null) {
            userEntity.setUserName(userRequestModel.getUserName());
            userEntity.setUserBalance(userRequestModel.getUserBalance());
            userEntity.setUserOrder(userRequestModel.getUserOrder());
            UserEntity updatedUserEntity = userRepository.save(userEntity);
            return new ResponseEntity<>(updatedUserEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> findByUserId(Long userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity != null) {
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }


}
