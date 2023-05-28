package com.springboot.ws.facade;

public class ZomatoFacade {
    private Restaurant restaurant;
    private DeliveryBoy deliveryBoy;
    private DeliveryTeam deliveryTeam;

    public ZomatoFacade(Restaurant restaurant, DeliveryBoy deliveryBoy, DeliveryTeam deliveryTeam) {
        this.restaurant = restaurant;
        this.deliveryBoy = deliveryBoy;
        this.deliveryTeam = deliveryTeam;
    }

    public void placeOrder(){
        restaurant.prepareOrder();
        deliveryTeam.assignDeliveryBoy();
        deliveryBoy.pickUpOrder();
        deliveryBoy.deliverOrder();
    }
}
