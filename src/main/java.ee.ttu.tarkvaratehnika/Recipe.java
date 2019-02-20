package main.java.ee.ttu.tarkvaratehnika;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String materials;
    private int price;
    private int portion;


    protected Recipe() {
    }

    public Recipe(String name, String description, String materials, int price, int portion) {
        this.name = name;
        this.description = description;
        this.materials = materials;
        this.price = price;
        this.portion = portion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return String.format(
                "Recipe[id=%d, name='%s', description='%s', materials='%s', price='%d', portion='%d']",
                id, name, description, materials, price, portion);
    }
}