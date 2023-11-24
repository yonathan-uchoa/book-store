package com.yusk.bookstore.rest;

import com.yusk.bookstore.dto.request.BookPostRequestBody;
import com.yusk.bookstore.mapper.BookMapper;
import com.yusk.bookstore.mapper.NewBookMapper;
import com.yusk.bookstore.model.Book;
import com.yusk.bookstore.model.BookSearch;
import com.yusk.bookstore.service.BookService;
import com.yusk.bookstore.service.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("library")
public class BookRestController {
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private BookService bookService;

    @GetMapping("/online")
    public ResponseEntity<BookSearch> searchOnline(@RequestParam String q, @RequestParam(defaultValue = "everything") String mode) {
        BookSearch books = libraryService.getBooks(q, mode);
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }
    @GetMapping
    public ResponseEntity<Iterable<Book>> searchAll(@RequestParam(required = false) String title) {
        if(title == null){
            return ResponseEntity.ok().body(bookService.searchAll());
        }
        return ResponseEntity.ok().body(bookService.findByTitleContaining(title));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> searchById(@PathVariable Integer id) {
        Optional<Book> book = bookService.searchById(id);
        if(book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<Book> save(@RequestBody BookPostRequestBody bookDTO) {
        Book _book = bookService.save(NewBookMapper.INSTANCE.dtoToBook(bookDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(_book);
    }

    @PutMapping("/{id}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody BookPostRequestBody bookDTO) {
        Optional<Book> _book = bookService.searchById(id);
        if(_book.isPresent()) {
            BookMapper.INSTANCE.updateBook(bookDTO, _book.get());
            bookService.save(_book.get());
            return ResponseEntity.ok().body(_book.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Optional<Book> _book = bookService.searchById(id);
        if(_book.isPresent()){
            String title = _book.get().getTitle();
            bookService.delete(id);
            return ResponseEntity.ok("client " + title + ", removed successful");
        }
        return ResponseEntity.notFound().build();
    }

}
