package com.bjit.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseModel {
    private Long userId;

    private String userName;
    private Long userBalance;
    private String userOrder;

    public Long getBalance() {
        return userBalance;
    }

    public void setBalance(Long balance) {
        this.userBalance = balance;
    }
}
