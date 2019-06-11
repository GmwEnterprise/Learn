package com.example.vuedemocrud.controller;

import com.example.vuedemocrud.mapper.PeopleMapper;
import com.example.vuedemocrud.po.People;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * people类基本增删改查接口提供
 *
 * @author Gmw
 */
@RestController
@RequestMapping("/people")
public class PeopleController {
    private static final Logger log = LoggerFactory.getLogger(PeopleController.class);
    private final PeopleMapper mapper;

    public PeopleController(PeopleMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    public PageInfo<People> list(Integer startPage, Integer pageSize) {
        startPage = startPage != null ? startPage : 1;
        pageSize = pageSize != null ? pageSize : 5;
        PageHelper.startPage(startPage, pageSize);
        PageInfo<People> pageInfo = new PageInfo<>(mapper.selectAll());
        log.info("page size: {}", pageInfo.getSize());
        return pageInfo;
    }

    @GetMapping("/{id}")
    public People one(@PathVariable Integer id) {
        People people = mapper.selectById(id);
        log.info(people.toString());
        return people;
    }

    @PostMapping
    public People add(@RequestBody People people) {
        int result = mapper.insert(people);
        if (result > 0) {
            log.info("success add.");
            return people;
        }
        log.error("failed add.");
        return null;
    }

    @PatchMapping
    public People update(@RequestBody People people) {
        int result = mapper.update(people);
        if (result > 0) {
            log.info("success update.");
            return people;
        }
        log.error("failed update.");
        return null;
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id) {
        int result = mapper.delete(id);
        if (result > 0) {
            log.info("success delete.");
        } else {
            log.error("failed add.");
        }
        return result;
    }
}
