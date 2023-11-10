package com.yusk.bookstore.dto.response;

import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.WishList;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientGetResponseBody {
    Integer id;
    String name;
    String username;
    List<Address> addresses;
    WishList wishList;
}
