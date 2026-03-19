package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

import java.util.ArrayList;

public class DeliveryCostTest {
    StandardParcel parcel = new StandardParcel("test", 2, "test", 2);
    FragileParcel parcel2 = new FragileParcel("test", 3, "test", 3);
    PerishableParcel parcel3 = new PerishableParcel("test", 3, "test", 3, 2);
    StandardParcel uraniumParcel = new StandardParcel("uranium", 1000, "uranium", 2);
    private final ArrayList<StandardParcel> testParcels = new ArrayList<>();
    ParcelBox testBox = new ParcelBox(100);


    @Test
    public void calculateStandardDeliveryCostTest() {
        double expectedCost = 4;
        double actualCost=parcel.calculateDeliveryCost();
        Assertions.assertEquals(expectedCost, actualCost);
        String result = "Expected cost: " + expectedCost + ", Actual cost: " + actualCost;
        System.out.println(result);
    }

    @Test
    public void calculateFragileDeliveryCostTest() {
        double expectedCost = 12;
        double actualCost=parcel2.calculateDeliveryCost();
        Assertions.assertEquals(expectedCost, actualCost);
        String result = "Expected cost: " + expectedCost + ", Actual cost: " + actualCost;
        System.out.println(result);
    }

    @Test
    public void calculatePerishableDeliveryCostTest() {
        double expectedCost = 9;
        double actualCost=parcel3.calculateDeliveryCost();
        Assertions.assertEquals(expectedCost, actualCost);
        String result = "Expected cost: " + expectedCost + ", Actual cost: " + actualCost;
        System.out.println(result);
    }

    @Test
    public void isExpiredReturnsTrueTest(){
        int currentDay = 5;
        Assertions.assertTrue(parcel3.isExpired(currentDay));
    }

    @Test
    public void isExpiredReturnsFalseTest(){
        int currentDay = 1;
        Assertions.assertFalse(parcel3.isExpired(currentDay));
    }

    @Test
    public void maxWeightExceededReturnsTrueTest(){
        testBox.addParcel(uraniumParcel);
        Assertions.assertTrue(testBox.getAllParcels().isEmpty());
    }
}
