package com.ocr.projet7.projet7.entities;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;

@Entity
public class Copy implements Serializable {
    @Id @GeneratedValue
    private Long id;

    private String serialNumber;

    @ManyToOne
    @JoinColumn(name ="id" )
    private Book book;

    public Copy() { super();}

    public Copy(String serialNumber, Book book) {
        this.serialNumber = serialNumber;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
