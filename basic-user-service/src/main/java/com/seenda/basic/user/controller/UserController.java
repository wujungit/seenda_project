package com.seenda.basic.user.controller;

import com.seenda.basic.common.dto.member.MemberDTO;
import com.seenda.basic.common.dto.user.LoginDTO;
import com.seenda.basic.common.dto.user.RegisterDTO;
import com.seenda.basic.common.enums.ResultEnum;
import com.seenda.basic.common.exception.BuzException;
import com.seenda.basic.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RefreshScope
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) throws Exception {
        String jwtToken = userService.login(dto);
        return jwtToken;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterDTO dto) {

    }

}
