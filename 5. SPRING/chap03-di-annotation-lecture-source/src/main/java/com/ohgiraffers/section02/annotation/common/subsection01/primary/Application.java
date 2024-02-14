package com.ohgiraffers.section02.annotation.common.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }
        PoketmonSerivce poketmonService = context.getBean("poketmonServicePrimary", PoketmonSerivce.class);

        poketmonService.poketmonAttack();
    }

}
