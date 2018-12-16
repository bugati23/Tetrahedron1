package service;

import model.Point;

import java.util.List;

public interface ValidationService {
    boolean isValidString(String string);
    boolean isValidPoint(List<Point> pointList);
}
