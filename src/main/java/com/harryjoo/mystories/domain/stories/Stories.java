package com.harryjoo.mystories.domain.stories;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Stories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String postedDate;

    private String modifiedDate;

    private String imagePath;

    private String writer;

    @Builder
    public Stories(String title, String content, String postedDate, String modifiedDate, String imagePath, String writer) {
        this.title = title;
        this.content = content;
        this.postedDate = postedDate;
        this.modifiedDate = modifiedDate;
        this.imagePath = imagePath;
        this.writer = writer;
    }



}
