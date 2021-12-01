package com.mycompany.book;

import com.mycompany.book.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Integer> {
    public Long countById(Integer id);
}
