package com.rocketseat.experts.club.jwtrefreshtoken.service;

import com.rocketseat.experts.club.jwtrefreshtoken.jwt.Util;
import com.rocketseat.experts.club.jwtrefreshtoken.model.RefreshToken;
import com.rocketseat.experts.club.jwtrefreshtoken.request.LoginRequest;
import com.rocketseat.experts.club.jwtrefreshtoken.response.LoginResponse;
import com.rocketseat.experts.club.jwtrefreshtoken.security.AppUser;
import com.rocketseat.experts.club.jwtrefreshtoken.security.SecurityConfig;
import com.rocketseat.experts.club.jwtrefreshtoken.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {




    @Autowired
    private Util util;

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    RefreshTokenService refreshTokenService;




    public ResponseEntity<?> login(LoginRequest loginRequest) throws Exception {
        try {

            Authentication authentication =
                    securityConfig.authenticationManagerBean().authenticate(
                            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
                    );


            final UserDetails userDetails = userAuthenticationService
                    .loadUserByUsername(loginRequest.getUsername());

            AppUser appUser = (AppUser) authentication.getPrincipal();


            final String jwtToken = util.generateToken(userDetails);

            RefreshToken refreshToken = refreshTokenService.createRefreshToken(appUser.getUser().getId());


            return ResponseEntity.ok(new LoginResponse(jwtToken, "Bearer", refreshToken.getToken(), appUser.getUsername(),
                    appUser.getUser().getId()));

        } catch (BadCredentialsException e) {

            throw new Exception("Usuário e senha incorretas", e);
        }


    }}

