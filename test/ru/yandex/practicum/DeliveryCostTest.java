package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

import java.util.ArrayList;

public class DeliveryCostTest {
    StandardParcel parcel = new StandardParcel("test", 2, "test", 2);
    FragileParcel parcel2 = new FragileParcel("test", 3, "test", 3);
    PerishableParcel parcel3 = new PerishableParcel("test", 3, "test", 3, 2);
    StandardParcel parcel4 = new StandardParcel("test", 0, "test", 0);


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
    public void calculateZeroWeightCostTest(){
        double expectedCost = 0;
        double actualCost = parcel4.calculateDeliveryCost();
        Assertions.assertEquals(expectedCost, actualCost);
    }



}
