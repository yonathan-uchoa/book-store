package com.yusk.bookstore.dto;

import com.yusk.bookstore.dto.response.AddressDTO;
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
    private WishList wishList;

}
