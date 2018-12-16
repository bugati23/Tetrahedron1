package service;

import exception.NotValidException;
import model.Tetrahedron;

import java.util.List;

public interface CreatorService {
    List<Tetrahedron> createTetrahedrons(String string) throws NotValidException;
}
