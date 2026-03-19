package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {


    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay){
        super(description, weight, deliveryAddress, sendDay);
    }
    @Override
    double getBaseCost() {
        return 2;
    }

    @Override
    protected String getParcelType() {
        return Parcel.ParcelType.STANDARD.getText();
    }
}
