package com.mx.mcsv.service.auth.security;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.mx.mcsv.service.auth.dto.RequestDto;

@Component
@ConfigurationProperties(prefix = "admin-paths")
public class RouteValidator {
	private List<RequestDto> paths;

	public List<RequestDto> getPaths() {
		return paths;
	}

	public boolean isAdminPath(RequestDto dto) {
		return paths.stream()
				.anyMatch(p -> Pattern.matches(p.getUri(), dto.getUri()) && p.getMethod().equals(dto.getMethod()));
	}

	public void setPaths(List<RequestDto> paths) {
		this.paths = paths;
	}
}