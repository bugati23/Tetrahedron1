package service;

import exception.NotFileException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReaderServiceImplTest {
    private static ReaderServiceImpl readerService;
    @BeforeClass
    public static void initReaderServiceImpl(){
        readerService = new ReaderServiceImpl();
    }
    @Test(expected = NotFileException.class)
    public void readFromFileExc() throws NotFileException{
        String filePath = "input1.txt";
        readerService.readFromFile(filePath);
    }
    @Test
    public void readFromFile() throws NotFileException {
        String filePath = "input.txt";
        readerService.readFromFile(filePath);
    }
    @AfterClass
    public static void deleteReaderService(){
        readerService = null;
    }
}