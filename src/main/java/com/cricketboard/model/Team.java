package com.cricketboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public final class Team {
    @Id
    private Integer id;
    private String name;

    public Team(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team() {
    }

    @Id
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Team) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Team[" +
                "id=" + id + ", " +
                "name=" + name + ']';
    }

}
