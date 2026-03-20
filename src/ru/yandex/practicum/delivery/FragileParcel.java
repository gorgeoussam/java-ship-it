package ru.yandex.practicum.delivery;

import static ru.yandex.practicum.delivery.AppConstants.FRAGILE_COST;
import static ru.yandex.practicum.delivery.ParcelType.FRAGILE;

public class FragileParcel extends Parcel implements Trackable{


    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay){
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    double getBaseCost() {
        return FRAGILE_COST;
    }

    @Override
    protected ParcelType getParcelType() {
        return FRAGILE;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + description +">> изменила местоположение на " + newLocation);
    }

}
