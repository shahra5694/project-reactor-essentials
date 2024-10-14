package com.springboot.ws.structuraldesignpatterns.adapter1;

import java.util.ArrayList;
import java.util.List;

public class SwiggyStore {
    List<Item> items = new ArrayList<>();
    public void addItems(Item item) {
        items.add(item);
    }
}
