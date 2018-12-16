package service;

import model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ValidationServiceImpl implements ValidationService {
    private static final Logger logger = LogManager.getLogger(ValidationServiceImpl.class);
    private List<Double> doubleList;
    @Override
    public boolean isValidString(String string){
        Scanner scanner = new Scanner(string);
        doubleList = new ArrayList<>();
        while(scanner.hasNext()){
            try {
                doubleList.add(scanner.nextDouble());
            }
            catch (InputMismatchException exc){
                logger.error("Is not valid string");
                return false;
            }
        }
        if(doubleList.size() != 12){
            logger.error("Is not valid string");
            return false;
        }
        logger.info("Is valid string");
        return true;
    }

    public List<Double> getDoubleList() {
        return doubleList;
    }

    @Override
    public boolean isValidPoint(List<Point> pointList){
        for(int i = 0; i < pointList.size() - 1; i++){
            for(int j = i + 1; j < pointList.size(); j++){
                if(pointList.get(i).equals(pointList.get(j))){
                    logger.error("Is not valid points");
                    return false;
                }
            }
        }
        logger.info("Is valid points");
        return true;
    }
}
