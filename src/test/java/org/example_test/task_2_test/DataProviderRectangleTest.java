package org.example_test.task_2_test;

import org.example.task_2.Rectangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderRectangleTest {
//    add Data provider for each test
    @DataProvider
    private Object[][] rectanglePerimeterProvider(){
        int n = 5;
        int m = 3;
        Object[][] res = new Object[n][m];

        res[0] = new Object[]{1,2,6};
        res[1] = new Object[]{2,2,8};
        res[2] = new Object[]{2,1,6};
        res[3] = new Object[]{8,1,18};
        res[4] = new Object[]{7,2,18};

        return res;
    }

    @DataProvider
    private Object[][] rectangleAreaProvider(){
        int n = 5;
        int m = 3;
        Object[][] res = new Object[n][m];

        res[0] = new Object[]{1,2,2};
        res[1] = new Object[]{3,2,6};
        res[2] = new Object[]{4,4,16};
        res[3] = new Object[]{10,2,20};
        res[4] = new Object[]{11,1,11};

        return res;
    }

    @DataProvider
    private Object[][] rectangleInvalidSizeProvider(){
        int n = 5;
        int m = 2;
        Object[][] res = new Object[n][m];

        res[0] = new Object[]{-1,1};
        res[1] = new Object[]{-1,0};
        res[2] = new Object[]{0,-1};
        res[3] = new Object[]{1,-1};
        res[4] = new Object[]{0,0};

        return res;
    }

    Rectangle rectangle = new Rectangle();

    @Test (dataProvider = "rectangleInvalidSizeProvider")
    public void perimeterWidthOrHeightLessThanZeroOrZeroTest(double a, double b) {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.perimeter(a,b);
                }
        );
    }
    @Test (dataProvider = "rectangleInvalidSizeProvider")
    public void areaWidthOrHeightLessThanZeroOrZeroTest(double a, double b) {
        Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    rectangle.area(a,b);
                }
        );
    }

    @Test (dataProvider = "rectanglePerimeterProvider")
    public void perimeterWidthAndHeightPositiveTest(double a, double b, double expected) throws Exception {
        double actual = rectangle.perimeter(a,b);

        Assert.assertEquals(actual, expected);
    }
    @Test (dataProvider = "rectangleAreaProvider")
    public void areaWidthAndHeightPositiveTest(double a, double b, double expected) throws Exception {
        double actual = rectangle.area(a,b);

        Assert.assertEquals(actual, expected);
    }
}
