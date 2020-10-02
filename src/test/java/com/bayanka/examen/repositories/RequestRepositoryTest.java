package com.bayanka.examen.repositories;

import com.bayanka.examen.ExamenApplication;
import com.bayanka.examen.repositories.domains.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {ExamenApplication.class, RestTemplateAutoConfiguration.class})
public class RequestRepositoryTest {

    @Autowired private DataSource dataSource;
    @Autowired private RestTemplate restTemplate;


    @Autowired
    private RequestRepository requestRepository;

    @Test
    void testSaveRequest(){
        Assertions.assertNotNull(dataSource);
        Request req = requestRepository.save(Request.builder()
                .originIp("192.168.0.1")
                .requestMethod("name")
                .requestDate(new Date()).build());
         Assertions.assertNotNull(req);
    }
}
