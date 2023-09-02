package com.cricketboard.model;

import com.cricketboard.domain.NewBowlActivity;
import com.cricketboard.domain.RunScoredActivity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(
        include = JsonTypeInfo.As.PROPERTY,
        property = "__typename",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RunScoredActivityDetails.class, name = "RunScoredActivityDetails")
})
public interface ActivityDetails extends Serializable {
}
