package org.example_test.task_2_test;

import org.example.task_2.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RectanglePerimeterTest {

    @Test
    public void perimeterWidthLessThanZeroTest() throws Exception {
        Rectangle rectangle = new Rectangle(-1, 1);

        Assert.assertThrows(
                IllegalArgumentException.class,
                rectangle::perimeter
        );
    }
    @Test
    public void perimeterHeightLessThanZeroTest() throws Exception {
        Rectangle rectangle = new Rectangle(1, -1);

        Assert.assertThrows(
                IllegalArgumentException.class,
                rectangle::perimeter
        );
    }
    @Test
    public void perimeterHeightZeroTest() throws Exception {
        Rectangle rectangle = new Rectangle(1, 0);

        Assert.assertThrows(
                IllegalArgumentException.class,
                rectangle::perimeter
        );
    }
    @Test
    public void perimeterWidthZeroTest() throws Exception {
        Rectangle rectangle = new Rectangle(0, 1);

        Assert.assertThrows(
                IllegalArgumentException.class,
                rectangle::perimeter
        );
    }

    @Test
    public void perimeterWidthAndHeightPositiveTest() throws Exception {
        Rectangle rectangle = new Rectangle(2, 5);

        double expected = 2+5+2+5;
        double actual = rectangle.perimeter();

        Assert.assertEquals(actual, expected);
    }

    @Parameters({ "first-name" })
    @Test
    public void testSingleString(String firstName) {
        System.out.println("Invoked testString " + firstName);
        assert "Cedric".equals(firstName);
    }

}
