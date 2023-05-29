package com.bjit.booklibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequestModel {
    private String bookName;
    private String authorName;
    private Long bookPrice;
    private Long item;

}