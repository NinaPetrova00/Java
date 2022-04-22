package com.citb408.deliveries;

public class DeliverableItem implements Deliverable {
    private DeliveryCategory deliveryCategory;

    public DeliverableItem(DeliveryCategory deliveryCategory) {
        this.deliveryCategory = deliveryCategory;
    }

    @Override
    public boolean isDelivered(double time) {
        return this.deliveryCategory.getMaxTime() >= time;
    }

    @Override
    public String toString() {
        return "DeliverableItem{" +
                "deliveryCategory=" + deliveryCategory +
                '}';
    }
}
