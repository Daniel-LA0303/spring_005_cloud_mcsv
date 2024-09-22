package com.mx.mcsv.service.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.mcsv.service.auth.dto.AuthUserDto;
import com.mx.mcsv.service.auth.dto.NewUserDto;
import com.mx.mcsv.service.auth.dto.RequestDto;
import com.mx.mcsv.service.auth.dto.TokenDto;
import com.mx.mcsv.service.auth.entity.AuthUser;
import com.mx.mcsv.service.auth.service.AuthUserService;

@RestController
@RequestMapping("/auth")
public class AuthUserController {
	@Autowired
	AuthUserService authUserService;

	@PostMapping("/create")
	public ResponseEntity<AuthUser> create(@RequestBody NewUserDto dto) {
		AuthUser authUser = authUserService.save(dto);
		if (authUser == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(authUser);
	}

	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody AuthUserDto dto) {
		TokenDto tokenDto = authUserService.login(dto);
		if (tokenDto == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(tokenDto);
	}

	@PostMapping("/validate")
	public ResponseEntity<TokenDto> validate(@RequestParam String token, @RequestBody RequestDto dto) {
		TokenDto tokenDto = authUserService.validate(token, dto);
		if (tokenDto == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(tokenDto);
	}
}