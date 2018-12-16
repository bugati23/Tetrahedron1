package service;

import exception.NotFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderServiceImpl implements ReaderService {
    private static final Logger logger = LogManager.getLogger(ReaderServiceImpl.class);
    @Override
    public List<String> readFromFile(String filePath) throws NotFileException {
        List<String> lines;
        Path path = Paths.get(filePath);
        if(Files.notExists(path)){
            logger.error("File not found");
           throw new NotFileException("File not found");
        }
        try (Stream<String> lineStream = Files.lines(path, StandardCharsets.UTF_8)){
            lines = lineStream.collect(Collectors.toList());
            logger.info("Successful reading");
        }
        catch (IOException e){
            logger.error("Unsuccessful reading");
            throw new NotFileException("Unsuccessful reading",e);
        }
        return lines;
    }

    public static void main(String[] args) throws NotFileException {
        new ReaderServiceImpl().readFromFile("input.txt");
    }
}
