package com.yusk.bookstore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientPostRequestBody {
    String name;
    String username;
    String password;
}
