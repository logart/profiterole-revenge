package com.exigen.common.domain;



import javax.persistence.*;

/**
 * Class {@code IngredientType} is an ordinary user defined Java class whose instances
 * describe ingredient with types
 * @author Victoria Ganzha
 * @date  20.06.13
 *
 */
@Entity
@Table(name = "type")
public class IngredientType {

    /**
     * {@code id} its a primary key for entity IngredientType
     */

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * {@code name} this field describes the unique name
     * of types ingredient. This name using for sorted
     * ingredient for types
     */
    private String name;

    public IngredientType() {
    }

    public IngredientType(String name){
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
