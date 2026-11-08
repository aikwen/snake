package com.snake.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {

        BCryptPasswordEncoder en = new BCryptPasswordEncoder();

        System.out.println(en.encode("pkwen"));
        System.out.println(en.encode("ptom"));
        System.out.println(en.encode("pjack"));
    }

}
