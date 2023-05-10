package ru.topjava.voting.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public class AbstractNames extends AbstractEntity {

    @NotBlank
    @Size(min = 1, max = 25)
    @Column(name = "name", nullable = false)
    public String name;

    public AbstractNames() {
    }

    public AbstractNames(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '(' + name + ')';
    }
}