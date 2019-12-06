package com.joey.webstart.module.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    private List<Book> books = new ArrayList<>();

    public BookServiceImpl() {
        books.add(new Book("aaa", "111", 2008));
        books.add(new Book("bbb", "222", 2007));
        books.add(new Book("ccc", "333", 2018));
        books.add(new Book("ddd", "444", 20010));
    }

    @Override
    public List<Book> bookList() {
        return books;
    }

    @Override
    public void donateBook(Book book) {
        books.add(book);
    }

    @Override
    public Book borrowBook(String name) {
        for (Book book :books) {
            if (book.name.equals(name)) return book;
        }
        throw new IllegalStateException("can't find book by name:"+name);
    }
}
