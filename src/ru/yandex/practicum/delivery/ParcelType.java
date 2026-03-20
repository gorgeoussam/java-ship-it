package ru.yandex.practicum.delivery;

public enum ParcelType {
    STANDARD("Стандартная"),
    FRAGILE("Хрупкая"),
    PERISHABLE("Скоропортящаяся");

    private final String text;

    ParcelType(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
}
