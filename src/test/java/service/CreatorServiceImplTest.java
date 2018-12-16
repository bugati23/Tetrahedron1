package service;

import exception.NotValidException;
import model.Point;
import model.Tetrahedron;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreatorServiceImplTest {
    private static CreatorService creatorService;
    private static List<Point> pointList;
    @BeforeClass
    public static void initCreateService(){
        creatorService = new CreatorServiceImpl();
    }
    @Before
    public void initPointList(){
        pointList = new ArrayList<>();
        pointList.add(new Point(2.4, 5.6, 8));
        pointList.add(new Point(5, 2.6, 10));
        pointList.add(new Point(4, 5, 6.6));
        pointList.add(new Point(9, 2, 4.1));
    }
    @Test
    public void createTetrahedrons() throws NotValidException {
        List<Tetrahedron> tetrahedronList = new ArrayList<>();
        tetrahedronList.add(new Tetrahedron(pointList));
        Assert.assertEquals(tetrahedronList,creatorService.createTetrahedrons("input.txt"));
    }
}