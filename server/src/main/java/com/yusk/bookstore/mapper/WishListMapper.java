package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.request.WishListPostRequestBody;
import com.yusk.bookstore.dto.request.WishListPutRequestBody;
import com.yusk.bookstore.model.WishList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WishListMapper {
    WishListMapper INSTANCE = Mappers.getMapper(WishListMapper.class);

    WishList toWishList(WishListPostRequestBody wishListPostRequestBody);

    void updateWishList(WishListPostRequestBody wishListPostRequestBody, @MappingTarget WishList wishList);
    void updateWishList(WishListPutRequestBody wishListPutRequestBody, @MappingTarget WishList wishList);
}
