package ru.yandex.practicum.delivery;

import static ru.yandex.practicum.delivery.AppConstants.PERISHABLE_COST;
import static ru.yandex.practicum.delivery.ParcelType.PERISHABLE;

public class PerishableParcel extends Parcel {

    private final int timeToLive;


    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    double getBaseCost() {
        return PERISHABLE_COST;
    }

    @Override
    protected ParcelType getParcelType() {
        return PERISHABLE;
    }


    public Boolean isExpired(int currentDay) {
       return (sendDay + timeToLive > currentDay);

    }
}


