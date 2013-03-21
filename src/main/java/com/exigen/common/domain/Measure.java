package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@code Measure} is an entity what describe all available measures
 *
 * @author Tony Soprano
 * @date Feb 26, 2013
 */
@Entity
@Table(name = "measures")
public class Measure implements Serializable {

    /**
     * {@code id} its a primary key for this entity
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * {@code title} its a field what contains title of measure
     */
    @Column(unique=true, nullable=false)
    private String title;

    /**
     * {@methods Measure} its a constructors for adding data in entity
     */
    public Measure() {

    }

    public Measure(String title) {
        this.title = title;
    }

    /**
     * {@methods } below its a getters and setters
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
