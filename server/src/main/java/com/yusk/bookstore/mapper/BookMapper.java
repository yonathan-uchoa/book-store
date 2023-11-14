package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.request.BookPostRequestBody;
import com.yusk.bookstore.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "wishLists", ignore = true)
    Book toBook (BookPostRequestBody bookPostRequestBody);

    void updateBook (BookPostRequestBody bookPostRequestBody, @MappingTarget Book book);
}
