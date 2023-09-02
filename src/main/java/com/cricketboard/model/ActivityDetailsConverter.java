package com.cricketboard.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Convert
public class ActivityDetailsConverter implements AttributeConverter<ActivityDetails, String> {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(ActivityDetails attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ActivityDetails convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData.getBytes(), ActivityDetails.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
