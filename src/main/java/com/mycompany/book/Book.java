
package com.mycompany.book;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, name = "BookName")
    private String bookName;

    @Column(length = 45, nullable = false, name = "BookPrices")
    private float bookPrices;

    @Column(length = 45, nullable = false, name = "BookPages")
    private Integer bookPages;

    @Column(length = 45, nullable = true, name = "BookDescriptions")
    private String bookDescriptions;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String new_bookName) {
        this.bookName = new_bookName;
    }

    public float getBookPrices() {
        return bookPrices;
    }
    public void setBookPrices(float bookPrices) {
        this.bookPrices = bookPrices;
    }

    public String getBookDescriptions() {
        return bookDescriptions;
    }
    public void setBookDescriptions(String bookDescriptions) {
        this.bookDescriptions = bookDescriptions;
    }

    public Integer getBookPages() {
        return bookPages;
    }
    public void setBookPages(Integer bookPages) {
        this.bookPages = bookPages;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +

                ", firstName='" + getBookName() + '\'' +
                '}';
    }

}
