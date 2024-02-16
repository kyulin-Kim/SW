package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {

    /* 설명. 핸들러 메소드(어노테이션을 활용해서 요청 방식 및 경로에 따라 각각 메소드가 작성됨 */
    @RequestMapping(value="/menu/regist")       // GET 요청 뿐 아니라 다른 요청 방식도 처리됨
//    @RequestMapping(value = "/menu/regist", method = RequestMethod.GET)
    public String registMenu(Model model) {       // Model은 응답할 페이지의 재료를 담는 객체이다.
        System.out.println("/menu/regist 경로의 GET 요청 받아보기");

        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함...");

        /* 설명. 핸들러 메소드에서 반환하는 String 값은 templates에 있는 view(html 파일)의 이름이다. */
        return "mappingResult";
    }

    @RequestMapping("/menu/modify")
    public String modifymenu(Model model) {
        model.addAttribute("message", "POST 방식의  메뉴 수정용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message", "GET 방식의  메뉴 수정용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message", "POST 방식의  메뉴 수정용 핸들러 메소드 호출함...");

        return "mappingResult";
    }
}
