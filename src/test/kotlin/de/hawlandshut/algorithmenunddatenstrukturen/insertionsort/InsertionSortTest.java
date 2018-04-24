package de.hawlandshut.algorithmenunddatenstrukturen.insertionsort;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsertionSortTest
{
    @Test
    public void test_insertionSort()
    {
        List list = new Random().ints().limit(1000).boxed().collect(Collectors.toList());

        InsertionSort.insertionSort(list);
        assertTrue(Ordering.<Integer>natural().isOrdered(list));
    }
}
