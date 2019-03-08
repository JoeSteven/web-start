package com.joey.webstart.book;

import com.joey.webstart.common.CommonHelper;
import com.joey.webstart.interceptor.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Book> bookList() {
        return service.bookList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book donateBook(@RequestBody Book book) {
        service.donateBook(book);
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Book borrowBook(@RequestParam(value = "name") String name) {
        return service.borrowBook(name);
    }
}
