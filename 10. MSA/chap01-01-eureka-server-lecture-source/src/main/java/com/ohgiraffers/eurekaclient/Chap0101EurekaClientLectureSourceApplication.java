package com.ohgiraffers.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

/* 설명. 유레카 서버의 자격을 등록(서버스 디스커버리로서 지금 프로젝트를 기동) */
@EnableEurekaServer
public class Chap0101EurekaClientLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap0101EurekaClientLectureSourceApplication.class, args);
    }

}
