package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 11.12.2018
 */
public class SortedArraysTest {
    /**
     * Test creation of one sorted arrays from two sorted without additional sort.
     */
    @Test
    public void addTwoSortedArraysTogetherAndLeftSorted() {
        int[] first = {0, 1, 5, 6, 6, 9};
        int[] second = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expect = {0, 1, 1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 9, 9};
        SortedArrays addTwoArrays = new SortedArrays();
        int[] result = addTwoArrays.AddArrays(first, second);
        assertThat(result, is(expect));
    }


    /**
     * Test creation of one sorted arrays from two sorted without additional sort.
     */
    @Test
    public void addTwoSortedArraysTogetherAndLeftSortedFirstArrayBigger() {
        int[] first = {0, 1, 5, 6};
        int[] second = {1, 2, 3};
        int[] expect = {0, 1, 1, 2, 3, 5, 6};
        SortedArrays addTwoArrays = new SortedArrays();
        int[] result = addTwoArrays.AddArrays(first, second);
        assertThat(result, is(expect));
    }

    /**
     * Test creation of one sorted arrays from two sorted without additional sort.
     */
    @Test
    public void addTwoSortedArraysTogetherAndLeftSortedSecondArrayBigger() {
        int[] first = {-1};
        int[] second = {0, 1, 2, 3, 5, 6};
        int[] expect = { -1, 0, 1, 2, 3, 5, 6};
        SortedArrays addTwoArrays = new SortedArrays();
        int[] result = addTwoArrays.AddArrays(first, second);
        assertThat(result, is(expect));
    }
}