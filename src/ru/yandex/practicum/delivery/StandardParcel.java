package ru.yandex.practicum.delivery;

import static ru.yandex.practicum.delivery.AppConstants.STANDARD_COST;
import static ru.yandex.practicum.delivery.ParcelType.STANDARD;

public class StandardParcel extends Parcel {


    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    double getBaseCost() {
        return STANDARD_COST;
    }

    @Override
    protected ParcelType getParcelType() {
        return STANDARD;
    }
}
