package com.example.todoapp.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TASKLİST")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "description", nullable =false)
    private String description;

    @Column(name="completed")
    private Boolean completed =Boolean.FALSE;

}
