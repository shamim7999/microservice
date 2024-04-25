package org.dsi.microservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
