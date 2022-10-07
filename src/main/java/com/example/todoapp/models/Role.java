package com.example.todoapp.models;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "role")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "role_id")
    private Long id;

    //@Column(name = "role_name")
    private String name;

    public Role(String name) {
        super();
        this.name = name;
    }

    //@ManyToMany(mappedBy = "roles")
    //private List<User> users = new ArrayList<>();

/**/

   /* @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }*/
}
