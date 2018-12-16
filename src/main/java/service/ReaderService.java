package service;

import exception.NotFileException;

import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String path)throws NotFileException;
}
