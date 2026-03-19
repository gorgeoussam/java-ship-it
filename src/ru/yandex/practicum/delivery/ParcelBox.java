package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final double maxWeight;
    private final ArrayList<T> parcels = new ArrayList<>();
    private double currentWeight = 0;

    public ParcelBox(double maxWeight) {
        this.maxWeight = maxWeight;

    }

    public void addParcel(T parcel){
        if (currentWeight + parcel.weight > maxWeight) {
            System.out.println("Коробка переполнена, посылка не добавлена");
            return;
        }
        parcels.add(parcel);
        currentWeight += parcel.weight;
    }

    public List<T> getAllParcels(){
        return parcels;
    }



    public void showAllParcels(){
        if (parcels.isEmpty()) {
            System.out.println("Коробка пустая");
            return;
        }
        for (T parcel : parcels) {
            System.out.println(parcel.description + " вес " + parcel.weight + " адрес доставки " + parcel.deliveryAddress);
        }
    }
}