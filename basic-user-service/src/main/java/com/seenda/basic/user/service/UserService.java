package com.seenda.basic.user.service;

import com.seenda.basic.common.dto.user.LoginDTO;
import com.seenda.basic.common.dto.user.RegisterDTO;

public interface UserService {

    public String login(LoginDTO dto) throws Exception;

    public void register(RegisterDTO dto) throws Exception;

}
