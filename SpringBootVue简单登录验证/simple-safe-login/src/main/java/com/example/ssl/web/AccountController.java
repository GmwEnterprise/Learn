package com.example.ssl.web;

import com.example.ssl.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(value = "/acc")
public class AccountController {

  @PostMapping("/login")
  public AjaxResponse login(HttpServletRequest request) {
    System.out.println(request.getParameterMap());
    return AjaxResponse.success();
  }
}
