package com.mx.mcsv.user.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mcsv-course", url = "${mcsv.course.url}")
public interface CourseClientRest {

	@DeleteMapping("/delete-user-by-id/{userId}")
	void deleteUserCourseById(@PathVariable Long userId);

}
