package de.hawlandshut.algorithmenunddatenstrukturen.quicksort;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static de.hawlandshut.algorithmenunddatenstrukturen.quicksort.QuickSortKt.quickSort;
import static org.junit.Assert.assertEquals;

public class QuickSortTestJava
{
    @Test
    public void test_quicksort_time_Mil_intList()
    {
        List<Integer> list = new Random().ints().limit(1_000_000).boxed().collect(Collectors.toList());
        List<Integer> list2 = new ArrayList(list);
        long l1 = System.nanoTime();
        quickSort(list);
        long l2 = System.nanoTime();
        l1 = l2 - l1;
        double d = ((double)l1) * Math.pow(10,-9);
        System.out.println("Sorting took "+d+" sec.");
    }
}
