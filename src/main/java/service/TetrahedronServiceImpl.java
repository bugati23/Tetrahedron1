package service;

import model.Point;
import model.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronServiceImpl implements TetrahedronService {
    @Override
    public boolean isShape(Tetrahedron tetrahedron) {
        List<Double> lengthList = new ArrayList<Double>(calcLength(calcVectors(tetrahedron)));
        double lengthFV = lengthList.get(0);
        for(int i = 1; i < lengthList.size(); i++){
            if(lengthFV != lengthList.get(i)){
                return false;
            }
        }
        return true;
    }
    private List<Double> calcLength(List<Point> vectorList){
        List<Double> lengthList = new ArrayList<Double>();
        for(Point vector : vectorList){
            lengthList.add(Math.sqrt(Math.pow(vector.getX(),2) + Math.pow(vector.getY(),2) + Math.pow(vector.getZ(),2)));
        }
        return lengthList;
    }
    private List<Point>  calcVectors(Tetrahedron tetrahedron){
        List<Point> points = new ArrayList<Point>(tetrahedron.getPoints());
        List<Point> vectors = new ArrayList<Point>();
        for(int i = 0; i < points.size(); i++){
            for(int j = i + 1; j < points.size(); j++){
                vectors.add(new Point(points.get(j).getX() - points.get(i).getX(),points.get(j).getY() - points.get(i).getY(),points.get(j).getZ() - points.get(i).getZ()));
            }
        }
        return vectors;
    }
    @Override
    public boolean OnCoordPlanes(Tetrahedron tetrahedron) {
        double sumX = 0;
        double sumY = 0;
        double sumZ = 0;
        for(int i = 0 ; i < 3; i++){
            Point point = tetrahedron.getPoints().get(i);
            sumX += Math.abs(point.getX());
            sumY += Math.abs(point.getY());
            sumZ += Math.abs(point.getZ());
        }
        if(sumX == 0 || sumY == 0 || sumZ == 0){
            return true;
        }
        return false;
    }
    @Override
    public double calcSurfaceArea(Tetrahedron tetrahedron) {
        Point vectorProduct = vectorProduct(tetrahedron);
        double result = 1.0/2 * Math.sqrt(Math.pow(vectorProduct.getX(),2) + Math.pow(vectorProduct.getY(),2) + Math.pow(vectorProduct.getZ(),2));
        return 4 * result;
    }
    private Point vectorProduct(Tetrahedron tetrahedron){
        List<Point> vectors = new ArrayList<Point>(calcVectors(tetrahedron));
        Point vector1 = vectors.get(0);
        Point vector2 = vectors.get(1);
        double x = (vector1.getY() * vector2.getZ()) - (vector1.getZ() * vector2.getY());
        double y = (vector1.getZ() * vector2.getX()) - (vector1.getX() * vector2.getZ());
        double z = (vector1.getX() * vector2.getY()) - (vector1.getY() * vector2.getX());
        Point returnVector = new Point(x,y,z);
        return returnVector;
    }
    @Override
    public double calcVolume(Tetrahedron tetrahedron) {
        return 1.0/6 * Math.abs(determinantMatrix(tetrahedron));
    }
    private void nonZeroFirstEl(int p, int dimension, double[][] matrix){
        double[] buffer;
        for(int i = p; i < dimension-1; i++){
            if(matrix[i][p] == 0){ // если 1 элемент  определителя равен 0
                for(int j = i+1; j < dimension; j++) { // поиск не нулевых элементов из этого столбца
                    if(matrix[j][p] != 0) {//меняем местами,если нашли
                        buffer = matrix[i];
                        matrix[i] = matrix[j];
                        matrix[j] = buffer;
                        matrix[p][p]=-matrix[p][p];
                    }
                }
            }
            else break;
        }
    }
    private double determinantMatrix(Tetrahedron tetrahedron){//по Гауссу
        final int  DIMENSION = 3;
        double[][] matrix = new double[DIMENSION][DIMENSION];
        List<Point> vectors = new ArrayList<Point>(calcVectors(tetrahedron));
        for(int i = 0; i < DIMENSION; i++){
            Point point = vectors.get(i);
            matrix[i][0] = point.getX();
            matrix[i][1] = point.getY();
            matrix[i][2] = point.getZ();
        }
        double determinant = 1;
        double factor = 0;
        double ymn = 0;
        for(int p = 0; p < DIMENSION; p++) {
            nonZeroFirstEl(p, DIMENSION, matrix); // проверка на 0
            factor = matrix[p][p];
            if(factor == 0){ // если все элементы столбцы p-порядка равны 0, то det = 0
                return 0;
            }
            else {
                for (int i = p + 1; i < DIMENSION; i++) { //производит преобразование матрицы так, чтобы только верхний левый
                    ymn = matrix[i][p] / matrix[p][p];   //элемент определителя был отличен от 0
                    for (int j = p; j < DIMENSION; j++) {
                        matrix[i][j] -= matrix[p][j] * ymn;
                    }
                }
                determinant *= factor;
            }
        }
        return determinant;
    }
    @Override
    public double calcRatioOfVolumes(Tetrahedron tetrahedron) {
        return 0;
    }
}
