package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();

    private static final ParcelBox<StandardParcel> standardParcelParcelBox = new ParcelBox<>(100);
    private static final ParcelBox<FragileParcel> fragileParcelParcelBox = new ParcelBox<>(50);
    private static final ParcelBox<PerishableParcel> perishableParcelParcelBox = new ParcelBox<>(20);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    if (trackableParcels.isEmpty()) {
                        System.out.println("Хрупких посылок не создано");
                    } else {
                        System.out.println("Введите новое местоположение для всех трекируемых посылок:");
                        String newLocation = scanner.nextLine();
                        for (Trackable trackable : trackableParcels) {
                            trackable.reportStatus(newLocation);
                        }
                    }
                    break;
                case 5:
                    showBoxContents();
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить статус трекинга");
        System.out.println("5 — Показать посылки в коробках");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Выбрать тип посылки 1-стандарт, 2-хрупкая, 3-скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println("Требуется описание посылки");
        String description = scanner.nextLine();
        System.out.println("Укажите вес");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.println("куда доставляем");
        String address = scanner.nextLine();
        System.out.println("когда отправляем");
        int day = Integer.parseInt(scanner.nextLine());

        Parcel parcel = null;
        switch (type) {
            case 1:
                parcel = new StandardParcel(description, weight, address, day);
                standardParcelParcelBox.addParcel((StandardParcel) parcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, address, day);
                trackableParcels.add(fragileParcel);
                parcel = fragileParcel;
                fragileParcelParcelBox.addParcel(fragileParcel);
                break;
            case 3:
                System.out.println("сколько хранится?");
                int ttl = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weight, address, day, ttl);
                perishableParcelParcelBox.addParcel((PerishableParcel) parcel);
                break;
            default:
                System.out.println("Нет такого типа");
        }

        if (parcel != null) {
            allParcels.add(parcel);
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            System.out.println(parcel.deliver());
        }
    }

    private static void calculateCosts() {
        double total = 0;
        for (Parcel parcel : allParcels) {
            total += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставки: " + total);
    }

    private static void showBoxContents() {
        System.out.println("Выбрать тип коробки 1-стандарт, 2-хрупкая, 3-скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                standardParcelParcelBox.showAllParcels();
                break;
            case 2:
                fragileParcelParcelBox.showAllParcels();
                break;
            case 3:
                perishableParcelParcelBox.showAllParcels();
                break;
            default:
                System.out.println("Нет такого типа коробки");
        }
    }
}