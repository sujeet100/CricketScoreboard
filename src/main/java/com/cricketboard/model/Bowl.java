package com.cricketboard.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Bowl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer matchId;
    @NotNull
    private Integer inningsId;
    @NotNull
    private Integer overNumber;
    @NotNull
    private Integer ballNumber;
    @Enumerated(EnumType.STRING)
    @NotNull
    private BallType ballType;
    @NotNull
    private Integer bowlerId;
    @NotNull
    private Double ballSpeed;
    @NotNull
    private Integer strikerBatterId;
    private Integer nonStrikerBatterId;
    private Integer run;
    @Enumerated(EnumType.STRING)
    private RunType runType;
    private Integer frontUmpireId;
    private Integer legUmpireId;
    private Integer wicketId;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timeStamp;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bowl bowl = (Bowl) o;
        return Objects.equals(id, bowl.id) && Objects.equals(matchId, bowl.matchId) && Objects.equals(inningsId, bowl.inningsId) && Objects.equals(overNumber, bowl.overNumber) && Objects.equals(ballNumber, bowl.ballNumber) && ballType == bowl.ballType && Objects.equals(bowlerId, bowl.bowlerId) && Objects.equals(ballSpeed, bowl.ballSpeed) && Objects.equals(strikerBatterId, bowl.strikerBatterId) && Objects.equals(nonStrikerBatterId, bowl.nonStrikerBatterId) && Objects.equals(run, bowl.run) && runType == bowl.runType && Objects.equals(frontUmpireId, bowl.frontUmpireId) && Objects.equals(legUmpireId, bowl.legUmpireId) && Objects.equals(wicketId, bowl.wicketId) && Objects.equals(timeStamp, bowl.timeStamp);
    }

    @Override
    public String toString() {
        return "Bowl{" +
                "id=" + id +
                ", matchId=" + matchId +
                ", inningsId=" + inningsId +
                ", overNumber=" + overNumber +
                ", ballNumber=" + ballNumber +
                ", ballType=" + ballType +
                ", bowlerId=" + bowlerId +
                ", ballSpeed=" + ballSpeed +
                ", strikerBatterId=" + strikerBatterId +
                ", nonStrikerBatterId=" + nonStrikerBatterId +
                ", run=" + run +
                ", runType=" + runType +
                ", frontUmpireId=" + frontUmpireId +
                ", legUmpireId=" + legUmpireId +
                ", wicketId=" + wicketId +
                ", timeStamp=" + timeStamp +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matchId, inningsId, overNumber, ballNumber, ballType, bowlerId, ballSpeed, strikerBatterId, nonStrikerBatterId, run, runType, frontUmpireId, legUmpireId, wicketId, timeStamp);
    }
}
