package com.natura.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.natura.config.JwtService;
import com.natura.entities.Cart;
import com.natura.entities.Role;
import com.natura.entities.TotalRoles;
import com.natura.entities.User;
import com.natura.payload.SingIn;
import com.natura.payload.UserDto;
import com.natura.repositories.UserRepo;
import com.natura.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserDto CreateUser(UserDto userDto) {
        User user= this.modelMapper.map(userDto, User.class);
        System.out.println("user details:" + user.getName());
        List<Role> list= new ArrayList<>();
                list.add(new Role(TotalRoles.ADMIN.name()));
        user.setRole(list);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Cart cart= new Cart();
        cart.setUser(user);
        user.setCart(cart);

        this.userRepo.save(user);
        return this.modelMapper.map(user,UserDto.class);
    }

    @Override
    public SingIn SingIn(SingIn singIn) {
    	System.out.println("Email:"+singIn.getEmail()+""+singIn.getPassword());
    	User user=this.userRepo.findByEmail(singIn.getEmail());
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(singIn.getEmail(),singIn.getPassword()));
        
        System.out.println("Email:"+user.getEmail());
        var jwtToken=jwtService.generateToken(user);
        singIn.setJwt(jwtToken);
        return singIn;
    }
}
