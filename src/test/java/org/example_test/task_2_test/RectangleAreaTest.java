package org.example_test.task_2_test;

import org.example.task_2.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleAreaTest {
    //+Task 1: Create 4 simple unit tests for Task_2 (modify your code to have 4 different methods in Task_2 solving if need).
    //+Task 2. Create testng.xml which should execute your test class. Execute this file
    //Task 3. add Data provider for each test
    //Task 4. Create a test with parameters loaded from testng.xml.
    //	Hint: url how to do it

    @Test
    public void areaWidthLessThanZeroTest() throws Exception {
        Rectangle rectangle = new Rectangle(-1, 1);

        Assert.assertThrows(
                IllegalArgumentException.class,
                rectangle::area
        );
    }
    @Test
    public void areaHeightLessThanZeroTest() throws Exception {
        Rectangle rectangle = new Rectangle(1, -1);

        Assert.assertThrows(
                IllegalArgumentException.class,
                rectangle::area
        );
    }
    @Test
    public void areaHeightZeroTest() throws Exception {
        Rectangle rectangle = new Rectangle(1, 0);

        Assert.assertThrows(
                IllegalArgumentException.class,
                rectangle::area
        );
    }
    @Test
    public void areaWidthZeroTest() throws Exception {
        Rectangle rectangle = new Rectangle(0, 1);

        Assert.assertThrows(
                IllegalArgumentException.class,
                rectangle::area
        );
    }

    @Test
    public void areaWidthAndHeightPositiveTest() throws Exception {
        Rectangle rectangle = new Rectangle(2, 5);

        double expected = 2*5;
        double actual = rectangle.area();

        Assert.assertEquals(actual, expected);
    }
}
