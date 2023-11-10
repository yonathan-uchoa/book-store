package com.yusk.bookstore.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class BookPostRequestBody {
    private Set<String> genre;
    private Set<String> author;
    private String title;
    private Float price;
    private String coverUrl;
}
