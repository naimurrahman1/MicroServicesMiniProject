package com.bjit.booklibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseModel {

    private String bookName;
    private String authorName;
    private Long bookPrice;
    private Long item;


}
