package de.hsos.swa.mocktail.entity;

import org.eclipse.microprofile.openapi.models.parameters.Parameter;

import java.util.Objects;


/*
 * Object Values sind Immutable
 * d.h: Klasse ist final -> Kann nicht vererbt werden
 * alle Instanzvariablen sind private
 * es gibt keine Setter
 */
public final class Ingredient {
    private  String name;
    private  int quantity;
    private String secretAttribute;

    public Ingredient(){

    }

    public Ingredient(String name, int quantity){
        this.name = Objects.requireNonNull(name);
        this.quantity = quantity;
    }

    public String getName(){
        return this.name;
    }

    public int getQuantity(){
        return this.quantity;
    }


}
