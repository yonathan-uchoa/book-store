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
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toBook(BookPostRequestBody bookPostRequestBody) {
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
        book.setCoverUrl( bookPostRequestBody.getCoverUrl() );

        return book;
    }

    @Override
    public void updateBook(BookPostRequestBody bookPostRequestBody, Book book) {
        if ( bookPostRequestBody == null ) {
            return;
        }

        if ( bookPostRequestBody.getTitle() != null ) {
            book.setTitle( bookPostRequestBody.getTitle() );
        }
        if ( book.getGenre() != null ) {
            Set<String> set = bookPostRequestBody.getGenre();
            if ( set != null ) {
                book.getGenre().clear();
                book.getGenre().addAll( set );
            }
        }
        else {
            Set<String> set = bookPostRequestBody.getGenre();
            if ( set != null ) {
                book.setGenre( new LinkedHashSet<String>( set ) );
            }
        }
        if ( bookPostRequestBody.getPrice() != null ) {
            book.setPrice( bookPostRequestBody.getPrice() );
        }
        if ( book.getAuthor() != null ) {
            Set<String> set1 = bookPostRequestBody.getAuthor();
            if ( set1 != null ) {
                book.getAuthor().clear();
                book.getAuthor().addAll( set1 );
            }
        }
        else {
            Set<String> set1 = bookPostRequestBody.getAuthor();
            if ( set1 != null ) {
                book.setAuthor( new LinkedHashSet<String>( set1 ) );
            }
        }
        if ( bookPostRequestBody.getCoverUrl() != null ) {
            book.setCoverUrl( bookPostRequestBody.getCoverUrl() );
        }
    }
}
