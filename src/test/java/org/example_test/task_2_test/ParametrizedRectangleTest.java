package org.example_test.task_2_test;

import org.example.task_2.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizedRectangleTest {

//    Create a test with parameters loaded from testng.xml

    Rectangle rectangle = new Rectangle();

    @Parameters({"a", "b", "expected"})
    @Test
    public void areaWidthAndHeightPositiveTest(double a, double b, double expected) throws Exception {
        double actual = rectangle.area(a,b);

        Assert.assertEquals(actual, expected);
    }
}
