package com.exigen.common.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class {@code Measure} is an entity what describe all available measures
 *
 * @author Tony Soprano
 * @date Feb 26, 2013
 */
@Entity
@Table(name = "measures")
public class Measure {

    /**
     * {@code id} its a primary key for this entity
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * {@code title} its a field what contains title of measure
     */
    private String title;

    /**
     * {@methods Measure} its a constructors for adding data in entity
     */
    public Measure() {

    }

    /**
     * {@methods } below its a getters and setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
