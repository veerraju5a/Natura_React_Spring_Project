package com.natura.services;

import com.natura.payload.SingIn;
import com.natura.payload.UserDto;

public interface UserService {


    UserDto CreateUser(UserDto userDto);
    UserDto CreateAdmin(UserDto userDto);
    SingIn SingIn(SingIn singIn);
}
