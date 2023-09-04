package com.cricketboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Inning {
    @Id
    private String inning_id;
    private String batting_team_id;

}
