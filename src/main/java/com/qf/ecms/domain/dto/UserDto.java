package com.qf.ecms.domain.dto;

import com.qf.ecms.domain.entity.UserItem;
import lombok.Data;

@Data
public class UserDto {
    private Integer userId;
    private String  userAccount;
    private UserItem userItem;

}
