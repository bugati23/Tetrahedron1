package service;

import model.Point;
import model.Tetrahedron;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TetrahedronServiceImplTest {
    private static TetrahedronService tetrahedronService;
    private static Tetrahedron tetrahedron;
    @BeforeClass
    public static void initTetrahedron(){
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(6.83, 6.83, 0));
        pointList.add(new Point(5, 0, 0));
        pointList.add(new Point(0, 5, 0));
        pointList.add(new Point(5.5, 5.5, 5));
        tetrahedron = new Tetrahedron(pointList);
        tetrahedronService = new TetrahedronServiceImpl();
    }
    @Test
    public void isShape() {
        Assert.assertFalse(tetrahedronService.isShape(tetrahedron));
    }

    @Test
    public void onCoordPlanes() {
        Assert.assertFalse(tetrahedronService.OnCoordPlanes(tetrahedron));
    }

    @Test
    public void calcSurfaceArea() {
        double expected = 86.6;
        Assert.assertEquals(expected,tetrahedronService.calcSurfaceArea(tetrahedron),0.01);
    }

    @Test
    public void calcVolume() {
        double expected = 36.083;
        Assert.assertEquals(expected,tetrahedronService.calcVolume(tetrahedron),0.01);
    }
}