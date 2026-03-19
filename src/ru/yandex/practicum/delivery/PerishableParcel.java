package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {

    private final int timeToLive;
    private boolean isExpired = false;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    double getBaseCost() {
        return 3;
    }

    @Override
    protected String getParcelType() {
        return Parcel.ParcelType.PERISHABLE.getText();
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }

    public Boolean isExpired(int currentDay) {
        if (sendDay + timeToLive >= currentDay) {
            isExpired = true;
        }
        return isExpired;
    }
}


