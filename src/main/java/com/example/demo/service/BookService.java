package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> createBookList(List<Book> list) {
		return bookRepository.saveAll(list);
	}
	
	public List<Book> getBookList() {
		return bookRepository.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public Book updateBookById(Book book) {
		
		Optional<Book> bookFound = bookRepository.findById(book.getId());
		
		if(bookFound.isPresent()) {
			Book bookUpdate = bookFound.get();
			bookUpdate.setName(book.getName());
			bookUpdate.setType(book.getType());
			bookUpdate.setAuthor(book.getAuthor());
			
			return bookRepository.save(bookUpdate);
		}
		else {
			return null;
		}
	}
	
	public String deleteBookById(int id) {
		bookRepository.deleteById(id);
		
		return "Book "+ id + " deleted";
	}
}
