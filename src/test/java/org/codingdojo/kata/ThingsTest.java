package org.codingdojo.kata;

import org.codingdojo.kata.exception.TooLongException;
import org.junit.Assert;
import org.junit.Test;

public class ThingsTest {
    @Test
    public void should_get_length() {
        Thing thing = new Thing(1, 3);
        Assert.assertEquals(thing.length(), 2);
    }

    @Test(expected = TooLongException.class)
    public void should_throw_exception_if_too_long() throws Exception {
        Thing thing = new Thing(1, 2000);
        thing.length();
    }

    @Test
    public void should_compare_two_things() {
        Thing thingA = new Thing(1, 10);
        Thing thingB = new Thing(2, 10);
        Assert.assertEquals(true,thingA > thingB);
    }
}
