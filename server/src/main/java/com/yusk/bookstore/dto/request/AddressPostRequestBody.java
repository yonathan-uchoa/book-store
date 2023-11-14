package com.yusk.bookstore.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressPostRequestBody {
    String surname;
    String complement;
    String cep;
    Integer number;
}
