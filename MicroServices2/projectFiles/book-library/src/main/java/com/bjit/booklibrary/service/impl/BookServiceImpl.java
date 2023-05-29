package com.bjit.booklibrary.service.impl;

import com.bjit.booklibrary.entity.BookEntity;
import com.bjit.booklibrary.model.BookRequestModel;
import com.bjit.booklibrary.repository.BookRepository;
import com.bjit.booklibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<Object> create(BookRequestModel bookRequestModel) {
        BookEntity bookEntity = BookEntity.builder()
                .bookName(bookRequestModel.getBookName())
                .authorName(bookRequestModel.getAuthorName())
                .bookPrice(bookRequestModel.getBookPrice())
                .item(bookRequestModel.getItem())
                .build();
        BookEntity savedBookEntity = bookRepository.save(bookEntity);

        return new ResponseEntity<>(savedBookEntity, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<Object> showAll() {
        List<BookEntity> bookList = bookRepository.findAll();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> delete(Long bookId) {
        BookEntity bookEntity = bookRepository.findByBookId(bookId);
        if (bookEntity == null) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
        bookRepository.deleteById(bookId);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateBookEntity(Long bookId, BookRequestModel requestModel) {
        BookEntity bookEntity = bookRepository.findByBookId(bookId);
        if (bookEntity == null) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
        // Update the bookEntity with the requestModel data
        bookEntity.setBookName(requestModel.getBookName());
        bookEntity.setAuthorName(requestModel.getAuthorName());
        bookEntity.setBookPrice(requestModel.getBookPrice());
        bookEntity.setItem(requestModel.getItem());
        BookEntity updatedBookEntity = bookRepository.save(bookEntity);
        return new ResponseEntity<>(updatedBookEntity, HttpStatus.OK);
    }

    //single user find
    @Override
    public ResponseEntity<Object> findByBookId(Long bookId) {
        BookEntity bookEntity = bookRepository.findByBookId(bookId);
        if (bookEntity == null) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookEntity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> getItemQuantity() {
        List<BookEntity> bookList = bookRepository.findAll();
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BookEntity firstBook = bookList.get(0);
        Long quantity = firstBook.getItem();
        return new ResponseEntity<>(quantity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> getBookPrice() {
        List<BookEntity> bookList = bookRepository.findAll();
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BookEntity firstBook = bookList.get(0);
        Long price = firstBook.getBookPrice();
        return new ResponseEntity<>(price, HttpStatus.OK);
    }


}


