package com.yusk.bookstore.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientPutRequestBody {
    String name;
    String password;
}
