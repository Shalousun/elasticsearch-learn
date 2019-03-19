package com.sunyu.elastic.controller;

import com.sunyu.elastic.model.Book;
import com.sunyu.elastic.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * es书籍数据操作
 * @author yu
 * Created by yu on 2017/6/27.
 */
@RestController
@RequestMapping("es")
public class EsController {

    @Resource
    private BookService bookService;

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 添加书籍
     *
     * @param book
     * @return
     */
    @PostMapping(value = "save")
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    /**
     * 根据图书编号查询图书
     *
     * @param id 图书编号
     * @return
     */
    @GetMapping(value = "query/{id}")
    public Book queryById(@PathVariable String id) {
        return bookService.findOne(id);
    }

    /**
     * 根据title查询
     *
     * @param title 书籍title
     * @return
     */
    @GetMapping(value = "findByTitle")
    public List<Book> findByTitle(String title) {
        return bookService.findByTitle(title);
    }

    /**
     * 分页查询图书编号
     *
     * @param page 页码,从0开始
     * @param size 每页大小
     * @return
     */
    @GetMapping(value = "page/{page}/{size}")
    public Page<Book> queryPage(@PathVariable int page, @PathVariable int size) {
        String author = "Rambabu Posa";
        return bookService.findByAuthor(author, PageRequest.of(page, size));
    }

    @RequestMapping("/singleWord/{page}/{size}")
    public  Object singleTitle(String word, @PathVariable int page, @PathVariable int size) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(word)).withPageable(PageRequest.of(page, size)).build();
        return elasticsearchTemplate.queryForList(searchQuery, Book.class);
    }
}
