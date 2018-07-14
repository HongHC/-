package com.hhc.code.DesignMode.Builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }
    public float getCost(){
        float cost = 0f;
        for(Item item : items){
            cost += item.Price();
        }
        return cost;
    }
    public void showItems(){
        for(Item item : items){
            System.out.println("Item:"+item.Name());
            System.out.println("Item.Packing:"+item.Packing());
            System.out.println("Item.Price:"+item.Price());
        }
    }
}