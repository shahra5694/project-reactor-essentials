package com.springboot.ws.adapter1;

public class MainClient {

    public static void main(String[] args) {
        SwiggyStore swiggyStore = new SwiggyStore();
        swiggyStore.addItems(new FoodItem());
        swiggyStore.addItems(new FoodItem());
        swiggyStore.addItems(new GroceryItemAdapter(new GroceryProduct()));
    }
}
