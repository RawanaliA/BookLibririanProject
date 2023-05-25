package com.example.exersicthestudentandlibririan.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @NotEmpty(message = "the name cannot be null")
    @Column(columnDefinition = "varchar(20) not null")

    private String name;
@NotEmpty(message = "the username cannot be null")
@Column(columnDefinition = "varchar(20) not null")

    private String username;
   @Pattern(regexp = "/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$/")
    private String password;
    @Email(message = "Enter Correct Email")
    @Column(columnDefinition = "varchar(20) not null UNIQUE")
    private String email;
}
