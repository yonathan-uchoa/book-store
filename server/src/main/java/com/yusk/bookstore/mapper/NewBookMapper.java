package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.request.BookPostRequestBody;
import com.yusk.bookstore.model.Book;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NewBookMapper {
    NewBookMapper INSTANCE = Mappers.getMapper(NewBookMapper.class);
    BookPostRequestBody bookToDTO(Book book);
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    Book dtoToBook(BookPostRequestBody bookPostRequestBody);
}
