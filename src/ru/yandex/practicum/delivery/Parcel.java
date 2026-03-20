package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    final String description;
    final double weight;
    final String deliveryAddress;
    final int sendDay;



    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    abstract double getBaseCost();

    protected abstract ParcelType getParcelType();

    public void packageItem(){

            System.out.println("Посылка <<" + description + ">> упакована как " + getParcelType());

    }

    public String deliver(){
        return "Посылка <<"+ description + ">> доставлена по адресу " + deliveryAddress;
    }

    public double calculateDeliveryCost(){
        return weight * getBaseCost();
    }


}
