package com.cricketboard.model;

import com.cricketboard.domain.ActivityType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer matchId;

    @NotNull
    private Integer inningsId;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    @Column(columnDefinition = "json")
    @Convert(converter = ActivityDetailsConverter.class)
    @ColumnTransformer(write = "?::json")
    private ActivityDetails activityDetails;

}
