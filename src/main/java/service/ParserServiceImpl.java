package service;

import exception.NotValidException;
import model.Point;

import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<Point> parse(String string){
        ValidationService myValid = new ValidationServiceImpl();
        if(myValid.isValidString(string)){
            List<Double> doubleList = new ArrayList<>(((ValidationServiceImpl) myValid).getDoubleList());
            List<Point> pointList = new ArrayList<>();
            for(int i = 0; i < doubleList.size() - 2; i += 3) {
                pointList.add(new Point(doubleList.get(i),doubleList.get(i+1),doubleList.get(i+2)));
            }
            if(myValid.isValidPoint(pointList)) {
                return pointList;
            }
        }
        return null;
    }
}
