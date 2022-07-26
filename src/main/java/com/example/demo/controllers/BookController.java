package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(bookService.getBookList());
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		return ResponseEntity.ok(this.bookService.getBookById(id));
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return ResponseEntity.ok(this.bookService.createBook(book));
	}
	
	@PostMapping("/addBooks")
	public ResponseEntity<List<Book>> addBooks(@RequestBody List<Book> list) {
		return ResponseEntity.ok(this.bookService.createBookList(list));
	}
	
	@PutMapping("/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		return ResponseEntity.ok(this.bookService.updateBookById(book));
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public HttpStatus deleteBook(@PathVariable int id) {
		this.bookService.deleteBookById(id);
		return HttpStatus.OK;
	}
}
