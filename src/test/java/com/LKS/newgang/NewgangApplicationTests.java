package com.LKS.newgang;


import com.LKS.newgang.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class NewgangApplicationTests {

	@Autowired
	private LoginService loginService;

	@Test
	void 로그인_TC01() {
		assertThat(loginService.authStudent(201713883, "201713883")).isEqualTo(true);
	}

	@Test
	void 로그인_TC02() {
		assertThat(loginService.authStudent(201713883, "INVALID")).isEqualTo(false);
	}


}
