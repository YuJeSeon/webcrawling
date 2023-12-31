package com.project.webcrawling.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crawling")
@Getter
@NoArgsConstructor
public class Crawling {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private Integer type;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String url;

    @Column(nullable = false)
    private LocalDateTime created_at;
}