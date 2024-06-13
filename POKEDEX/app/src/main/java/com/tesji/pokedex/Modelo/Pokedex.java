package com.tesji.pokedex.Modelo;

public class Pokedex {

    private String id;
    private String name;
    private String height;
    private String weight;
    private Spritest sprites=new Spritest();
    private String front_default = sprites.getFront_default();

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    public Spritest getSprites() {
        return sprites;
    }

    public void setSprites(Spritest sprites) {
        this.sprites = sprites;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Pokedex(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
