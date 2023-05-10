package ru.topjava.voting.to;

import ru.topjava.voting.HasUserId;

public abstract class EntityTo implements HasUserId {
    public Integer id;

    public EntityTo() {
    }

    public EntityTo(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}