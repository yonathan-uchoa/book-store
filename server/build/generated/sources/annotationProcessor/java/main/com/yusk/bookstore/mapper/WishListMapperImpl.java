package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.request.WishListPostRequestBody;
import com.yusk.bookstore.dto.request.WishListPutRequestBody;
import com.yusk.bookstore.model.WishList;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-10T10:28:34-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class WishListMapperImpl implements WishListMapper {

    @Override
    public WishList toWishList(WishListPostRequestBody wishListPostRequestBody) {
        if ( wishListPostRequestBody == null ) {
            return null;
        }

        WishList wishList = new WishList();

        wishList.setName( wishListPostRequestBody.getName() );

        return wishList;
    }

    @Override
    public void updateWishList(WishListPostRequestBody wishListPostRequestBody, WishList wishList) {
        if ( wishListPostRequestBody == null ) {
            return;
        }

        if ( wishListPostRequestBody.getName() != null ) {
            wishList.setName( wishListPostRequestBody.getName() );
        }
    }

    @Override
    public void updateWishList(WishListPutRequestBody wishListPutRequestBody, WishList wishList) {
        if ( wishListPutRequestBody == null ) {
            return;
        }

        if ( wishListPutRequestBody.getName() != null ) {
            wishList.setName( wishListPutRequestBody.getName() );
        }
    }
}
