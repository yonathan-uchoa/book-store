package com.yusk.bookstore.dto;

import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.model.WishList;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientDTO {
    private Integer id;
    private String name;
    private String username;
    private List<AddressDTO> addresses;
    private List<WishList> wishLists;

}
