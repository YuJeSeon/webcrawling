package com.project.webcrawling.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO {
    private Integer id;
    private Integer type;
    private String title;
    private String url;
}