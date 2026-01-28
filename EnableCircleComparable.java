public class EnableCircleComparable {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2.0);
        Circle circle2 = new Circle(2.0);

        System.out.println(circle1.compareTo(circle2));
    }
}

class Circle extends GeometricObject implements Comparable<Circle>{
    private double radius;

    public Circle() {

    }

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 2 * radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public int compareTo(Circle circ) {
        if (this.radius < circ.radius) {
            return -1;
        } else if (this.radius > circ.radius) {
            return 1;
        } else {
            return 0;
        }
    }

    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() + 
            " and the radius is" + radius);
    }
}
