package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class ParcelExpiryTest {
    PerishableParcel parcel3 = new PerishableParcel("test", 3, "test", 4, 5);

//isExpired condition: sendDay+TTL > currentDay



    @Test
    public void isExpiredReturnsFalseTest(){
        int currentDay = 9; //sendDay+TTL = 9 not expired
        Assertions.assertFalse(parcel3.isExpired(currentDay));
    }

    @Test
    public void isExpiredReturnsTrueTest(){
        int currentDay = 10; //sendDay+TTL = 9 expired
        Assertions.assertTrue(parcel3.isExpired(currentDay));
    }
}
