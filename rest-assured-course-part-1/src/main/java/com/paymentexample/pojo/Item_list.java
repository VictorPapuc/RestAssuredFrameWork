package com.paymentexample.pojo;

import java.util.List;

public class Item_list {

    private ShippingAdress shippingAdress;
    private List<Items> items;

    public ShippingAdress getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(ShippingAdress shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }



}
