package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.request.BookPostRequestBody;
import com.yusk.bookstore.model.Book;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-11T18:04:41-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class NewBookMapperImpl implements NewBookMapper {

    @Override
    public BookPostRequestBody bookToDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookPostRequestBody bookPostRequestBody = new BookPostRequestBody();

        Set<String> set = book.getGenre();
        if ( set != null ) {
            bookPostRequestBody.setGenre( new LinkedHashSet<String>( set ) );
        }
        Set<String> set1 = book.getAuthor();
        if ( set1 != null ) {
            bookPostRequestBody.setAuthor( new LinkedHashSet<String>( set1 ) );
        }
        bookPostRequestBody.setTitle( book.getTitle() );
        bookPostRequestBody.setPrice( book.getPrice() );
        bookPostRequestBody.setCoverUrl( book.getCoverUrl() );

        return bookPostRequestBody;
    }

    @Override
    public Book dtoToBook(BookPostRequestBody bookPostRequestBody) {
        if ( bookPostRequestBody == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( bookPostRequestBody.getTitle() );
        Set<String> set = bookPostRequestBody.getGenre();
        if ( set != null ) {
            book.setGenre( new LinkedHashSet<String>( set ) );
        }
        book.setPrice( bookPostRequestBody.getPrice() );
        Set<String> set1 = bookPostRequestBody.getAuthor();
        if ( set1 != null ) {
            book.setAuthor( new LinkedHashSet<String>( set1 ) );
        }
        book.setCoverUrl( bookPostRequestBody.getCoverUrl() );

        return book;
    }
}
