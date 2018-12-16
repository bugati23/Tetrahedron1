package service;

import model.Point;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidationServiceImplTest {
    private static ValidationService validationService;
    @BeforeClass
    public static void initValidationService(){
        validationService = new ValidationServiceImpl();
    }
    @Test
    public void isValidString() {
        String string = "2,3 5,6 8 5 2,6 10 4 5 6,6 9 2 4,1";
        Assert.assertTrue(validationService.isValidString(string));
    }

    @Test
    public void isValidPoint() {
        List<Point> pointList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            pointList.add(new Point(0,0,0));
        }
        Assert.assertFalse(validationService.isValidPoint(pointList));
    }
    @AfterClass
    public static void deleteValidationService(){
        validationService = null;
    }
}