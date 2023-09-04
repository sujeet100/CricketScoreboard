package com.cricketboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TeamPlayers {
    @Id
    private Integer id;
    private String matchId;
    private String teamId;
    private Integer playerId;
    private Integer order;
    private Integer captain;
    private Integer wicketKeeper;
}

