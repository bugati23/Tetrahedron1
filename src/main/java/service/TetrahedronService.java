package service;

import model.Tetrahedron;

public interface TetrahedronService {
    boolean isShape(Tetrahedron pyramid);
    boolean OnCoordPlanes(Tetrahedron pyramid);
    double calcSurfaceArea(Tetrahedron tetrahedron);
    double calcVolume(Tetrahedron tetrahedron);
    double calcRatioOfVolumes(Tetrahedron tetrahedron);
}
