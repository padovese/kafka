package com.github.padovese.kafka.model;

import java.time.LocalDateTime;

/**
 * @author padovese
 * @since 10/02/2020
 */

public class SomeEntity {

    private int id;
    private String name;

    public SomeEntity(){}

    public SomeEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SomeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}