package model;

import java.util.ArrayList;
import java.util.Collections;

public class Toy {
    protected int id;
    protected String name;
    protected int amount;
    protected int dropChance;
    public static ArrayList<Toy> toysList = new ArrayList<>();


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDropChance(int dropChance) {
        this.dropChance = dropChance;
    }

    public static int newId() {
        ArrayList<Integer> listId = new ArrayList<>();
        for (Toy toy: toysList) {
            listId.add(toy.id);
        }
        if (listId.isEmpty()) return 1;
        else return Collections.max(listId) + 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getDropChance() {
        return dropChance;
    }

    public String getToyInfo() {
        return
                " ID: " + id +
                        " Name: " + name +
                        " Amount: " + amount +
                        " Drop: " + dropChance;
    }
}
