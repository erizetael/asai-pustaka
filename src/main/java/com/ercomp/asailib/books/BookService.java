package com.ercomp.asailib.books;

import java.util.List;

public interface BookService {
    List<BookModel> getAllBooks();
    void saveBook(BookModel bookModel);
}
