package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

import java.util.ArrayList;

public class ParcelBoxCapacityTest {
    ParcelBox parcelBox = new ParcelBox(1000);
    Parcel parcel = new StandardParcel("test", 1001, "test", 100);
    Parcel uraniumParcel = new StandardParcel("uranium", 1000, "uranium", 100);
    Parcel surpriseMF = new StandardParcel("surprise", 0, "surprise", 100);

    @Test
    public void maxWeightExceededReturnsTrueTest(){
        parcelBox.addParcel(parcel);
        Assertions.assertTrue(parcelBox.getAllParcels().isEmpty());
    }

    @Test
    public void maxWeightEqualsBoxCapacityreturnsTrueTest(){
        parcelBox.addParcel(uraniumParcel);
        Assertions.assertEquals(1, parcelBox.getAllParcels().size());
    }

    @Test
    public void addTwoParcelsReturnTrueTest(){
        parcelBox.addParcel(surpriseMF);
        parcelBox.addParcel(uraniumParcel);
        Assertions.assertEquals(2, parcelBox.getAllParcels().size());
    }
}
