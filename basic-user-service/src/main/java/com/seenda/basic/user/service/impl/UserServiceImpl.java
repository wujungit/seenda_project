package com.seenda.basic.user.service.impl;

import com.seenda.basic.common.dto.user.LoginDTO;
import com.seenda.basic.common.dto.user.RegisterDTO;
import com.seenda.basic.common.enums.ResultEnum;
import com.seenda.basic.common.exception.BuzException;
import com.seenda.basic.common.util.JwtUtil;
import com.seenda.basic.common.util.MD5Util;
import com.seenda.basic.user.dao.UserMapper;
import com.seenda.basic.user.entity.User;
import com.seenda.basic.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(LoginDTO dto) throws Exception {
        String username = dto.getUsername();
        String password = dto.getPassword();
        if (StringUtils.isBlank(username)) {
            throw new BuzException(ResultEnum.DATA_NOT_FOUND);
        }
        if (StringUtils.isBlank(password)) {
            throw new BuzException(ResultEnum.DATA_NOT_FOUND);
        }
        // 通过用户名判断用户是否存在
        User user = new User();
        // 加密方式MD5
        if (!MD5Util.encrypt(password).equals(user.getPassword())) {
            throw new BuzException(ResultEnum.DATA_NOT_FOUND);
        }
        //登录成功
        String jwtToken = JwtUtil.getJwtToken("", "");
        return jwtToken;
    }

    @Override
    public void register(RegisterDTO dto) throws Exception {
        String username = dto.getUsername();
        String password = dto.getPassword();
        String fullname = dto.getFullname();
        String mobile = dto.getMobile();

    }
}
