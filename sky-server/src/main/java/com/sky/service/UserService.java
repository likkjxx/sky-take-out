package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @author Zz
 * @version 1.0
 * @description:
 * @date 2024/3/31 14:45
 */
public interface UserService {

    User wxLogin(UserLoginDTO userLoginDTO);

}
