package com.cricketboard.model;

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
        @JsonSubTypes.Type(value = RunScoredActivityDetails.class, name = "RunScoredActivityDetails"),
        @JsonSubTypes.Type(value = MatchStartedActivityDetails.class, name = "MatchStartedActivity"),
        @JsonSubTypes.Type(value = NewInningsActivityDetails.class, name = "NewInningsActivity")
})
public interface ActivityDetails extends Serializable {
}
