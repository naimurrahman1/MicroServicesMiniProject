package com.bjit.userservice.service;

import com.bjit.userservice.model.UserRequestModel;
import com.bjit.userservice.model.UserResponseModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> create(UserRequestModel userRequestModel);
    ResponseEntity<Object> showAll();
    ResponseEntity<Object>delete(Long userId);
    ResponseEntity<Object> updateUserEntity(Long userId, UserRequestModel userRequestModel);
    ResponseEntity<Object> findByUserId(Long userId);

}
