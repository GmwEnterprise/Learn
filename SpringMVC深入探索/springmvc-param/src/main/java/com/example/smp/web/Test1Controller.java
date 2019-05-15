package com.example.smp.web;

import com.example.smp.domain.Class;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/t1")
public class Test1Controller {

  @PostMapping("/class")
  String postSetClassNoAnnotation(Class data) {
    String toString = data.toString();
    System.out.println(toString);
    return toString;
  }

  @GetMapping("/class")
  String getSetClassNoAnnotation(Class data) {
    String toString = data.toString();
    System.out.println(toString);
    return data.toString();
  }
}
