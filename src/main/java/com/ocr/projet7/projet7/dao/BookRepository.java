package com.ocr.projet7.projet7.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
