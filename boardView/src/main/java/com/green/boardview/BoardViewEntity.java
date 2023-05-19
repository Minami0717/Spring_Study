package com.green.boardview;

import lombok.Data;

@Data
public class BoardViewEntity {
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String createdAt;
    private String updatedAt;
}
