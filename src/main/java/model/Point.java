package model;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point(){
        this(0,0,0);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('(').append(x);
        sb.append("; ").append(y);
        sb.append("; ").append(z);
        sb.append(')');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result +  (int)(Double.doubleToLongBits(x) - (Double.doubleToLongBits(x) >>> 32));
        result = prime * result +  (int)(Double.doubleToLongBits(y) - (Double.doubleToLongBits(y) >>> 32));
        result = prime * result +  (int)(Double.doubleToLongBits(z) - (Double.doubleToLongBits(z) >>> 32));
        return result;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }

}
