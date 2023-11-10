package com.yusk.bookstore.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientPostRequestBody {
    String name;
    String username;
    String password;
}
