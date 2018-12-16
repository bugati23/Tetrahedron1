package service;

import model.Point;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParserServiceImplTest {
    private static ParserService parserService;
    @BeforeClass
    public static void initParserService(){
        parserService = new ParserServiceImpl();
    }
    @Test
    public void parse() {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(2.4, 5.6, 8));
        pointList.add(new Point(5, 2.6, 10));
        pointList.add(new Point(4, 5, 6.6));
        pointList.add(new Point(9, 2, 4.1));
        Assert.assertEquals(pointList,parserService.parse("2,4 5,6 8 5 2,6 10 4 5 6,6 9 2 4,1"));
    }
    @AfterClass
    public static void deleteParserService(){
        parserService = null;
    }
}