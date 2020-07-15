package com.qf.ecms.domain.dto;

import com.qf.ecms.domain.entity.User;
import lombok.Data;

@Data
public class RegisterDto {
    private User user;
    private String phone;
    private String email;

}
