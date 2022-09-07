//package com.example.backend;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class BeanTest {
//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
//
//    @Test
//    @DisplayName("모든 빈 출력하기")
//    void findAllBean(){
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            Object bean = ac.getBean(beanDefinitionName);
//            System.out.println("name = " + beanDefinitionName + " object = " + bean);
//        }
//    }
//
//    @Test
//    @DisplayName("애플리케이션 빈 출력")
//    void findApplicationBean(){
//        String [] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
//
//            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE){
//                Object bean = ac.getBean(beanDefinitionName);
//                System.out.println("name = " + beanDefinitionName + "\nbean = " + bean);
//            }
//        }
//    }
//}
//
