package com.yusk.bookstore.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WishListPostRequestBody {
    private String name;
    @NotNull
    private Integer clientId;
}
