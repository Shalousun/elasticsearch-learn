package com.sunyu.elastic.controller;

import com.sunyu.elastic.model.Book;
import com.sunyu.elastic.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yu on 2017/6/27.
 */
@RestController
@RequestMapping("es")
public class EsController {

    @Resource
    private BookService bookService;

    @GetMapping(value = "query/{id}")
    public Book queryById(@PathVariable String id){
        return bookService.findOne(id);
    }
}
