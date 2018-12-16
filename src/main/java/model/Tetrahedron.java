package model;

import java.util.ArrayList;
import java.util.List;

public class Tetrahedron {
    private List<Point> points;
    private static int COUNT;
    private int number;
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tetrahedron ");
        sb.append(number).append(" :");
        sb.append(points).append('\n');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return points.equals(that.points);
    }

    @Override
    public int hashCode() {
        int result = 17;
        for(Point point : points){
            result = 37 * result + point.hashCode();
        }
        return result;
    }

    public Tetrahedron(List<Point> points) {
        this.points = new ArrayList<>(points);
        COUNT++;
        number = COUNT;
    }

    public Tetrahedron(){
        this(new ArrayList<>());
    }
    public List<Point> getPoints() {
        return points;
    }

}

