package com.cricketboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Entity
@Builder(setterPrefix = "with")
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public final class Team {
    @Id
    private String id;
    private String name;
    private String abbrevation;
    private String category;

    public Team() {
    }
}
