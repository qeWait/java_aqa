package org.example_test.task_2_test;

import org.example.task_2.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTest {
    Rectangle rectangle = new Rectangle();


    //Create 4 simple unit tests for Task_2 (modify your code to have 4 different methods in Task_2 solving if need).
    @Test
    public void perimeterWidthLessThanZeroTest() throws Exception {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.perimeter(-1,1);
                }
        );
    }
    @Test
    public void perimeterHeightLessThanZeroTest() throws Exception {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.perimeter(1,-1);
                }
        );
    }
    @Test
    public void perimeterHeightZeroTest() throws Exception {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.perimeter(1,0);
                }
        );
    }
    @Test
    public void perimeterWidthZeroTest() throws Exception {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.perimeter(0,1);
                }
        );
    }

    @Test
    public void perimeterWidthAndHeightPositiveTest() throws Exception {

        double expected = 14;
        double actual = rectangle.perimeter(2,5);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void areaWidthLessThanZeroTest() throws Exception {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.perimeter(-1,1);
                }
        );
    }
    @Test
    public void areaHeightLessThanZeroTest() throws Exception {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.perimeter(1,-1);
                }
        );
    }
    @Test
    public void areaHeightZeroTest() throws Exception {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.perimeter(1,0);
                }
        );
    }
    @Test
    public void areaWidthZeroTest() throws Exception {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.perimeter(0,1);
                }
        );
    }

    @Test
    public void areaWidthAndHeightPositiveTest() throws Exception {
        double expected = 10;
        double actual = rectangle.area(2,5);

        Assert.assertEquals(actual, expected);
    }
}
