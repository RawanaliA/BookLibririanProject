package com.example.exersicthestudentandlibririan.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//id : Integer
//title :String
//Author :String
//        Category : String (check Academic or Mystery or Novel )
//     ISBN :Integer
//numberOfPages :Integer (min 50 pages)
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@NotEmpty(message = "The Title Canot be null ")
@Column(columnDefinition = "varchar(20) not null")
private String title;
    @NotEmpty(message = "The Author Canot be null ")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;
    @Column(columnDefinition = " varchar(20) not null check (category='Academic' or category='Mystery' or category='Novel')")
    private String category;
    @NotNull(message = "The isbn Canot be null ")
    @Column(columnDefinition = "varchar(20) not null")
    private int isbn;
    @Min(value = 50 ,message = "The Page ShouldNot be less then 50")
    @Column(columnDefinition = "varchar(20) not null")
    private int numberOfPages;
}


