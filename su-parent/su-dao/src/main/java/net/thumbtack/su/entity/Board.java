package net.thumbtack.su.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Board {

    private long id;
    private String value;

    public Board(String boardAsString) {
        value = boardAsString;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }






}
