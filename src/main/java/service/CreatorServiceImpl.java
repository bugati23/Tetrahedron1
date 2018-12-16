package service;

import exception.NotFileException;
import exception.NotValidException;
import model.Point;
import model.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CreatorServiceImpl implements CreatorService {
    private static final Logger logger = LogManager.getLogger(CreatorServiceImpl.class);
    private List<Tetrahedron> tetrahedronList;
    @Override
    public List<Tetrahedron> createTetrahedrons(String string) {
        try {
            ReaderService myReader = new ReaderServiceImpl();
            List<String> stringList = myReader.readFromFile(string);
            ParserService myParser = new ParserServiceImpl();
            tetrahedronList = new ArrayList<>();
            for (int i = 0; i < stringList.size(); i++) {
                List<Point> listPoint = myParser.parse(stringList.get(i));
                if (listPoint != null) {
                    tetrahedronList.add(new Tetrahedron(listPoint));
                }
            }
            if(tetrahedronList.size() == 0){
                throw new NotValidException("Not Valid Arg From File");
            }
        }
        catch (NotFileException nfe){
            logger.error(nfe);
        }
        catch (NotValidException nve){
            logger.error(nve);
        }
        return tetrahedronList;
    }

    public static void main(String[] args){
        System.out.println(new CreatorServiceImpl().createTetrahedrons("input.txt"));
    }
}
