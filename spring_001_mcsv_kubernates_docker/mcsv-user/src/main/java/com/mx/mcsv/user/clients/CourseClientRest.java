package com.mx.mcsv.user.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mcsv-cours", url = "localhost:8082")
public interface CourseClientRest {

	@DeleteMapping("/delete-user-by-id/{userId}")
	void deleteUserCourseById(@PathVariable Long userId);

}
