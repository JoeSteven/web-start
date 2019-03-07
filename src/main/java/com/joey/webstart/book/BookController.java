package com.joey.webstart.book;

import com.joey.webstart.common.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ModelAndView bookList() {
        return CommonHelper.generate(service.bookList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView donateBook(@RequestBody Book book) {
        service.donateBook(book);
        return CommonHelper.generate(null);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView borrowBook(@RequestParam(value = "name") String name) {
        return CommonHelper.generate(service.borrowBook(name));
    }
}
