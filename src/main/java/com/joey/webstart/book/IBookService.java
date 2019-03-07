package com.joey.webstart.book;

import java.util.List;

public interface IBookService {
    List<Book> bookList();
    void donateBook(Book book);
    Book borrowBook(String name);
}
