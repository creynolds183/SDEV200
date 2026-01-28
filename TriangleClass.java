import java.util.Scanner;

public class TriangleClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a side length");
        Double side1 = input.nextDouble();
        System.out.println("Enter a side length");
        Double side2 = input.nextDouble();
        System.out.println("Enter a side length");
        Double side3 = input.nextDouble();
        System.out.println("Enter a color");
        String color = input.next();
        System.out.println("Is the triangle filled true/false");
        Boolean filled = input.nextBoolean();

        Triangle triangle1 = new Triangle(side1, side2, side3);
        triangle1.setColor(color);
        triangle1.setFilled(filled);

        System.out.println("triangle1 area: " + triangle1.getArea() + " triangle1 perimeter: " + triangle1.getPerimeter() + " triangle1 color: " + triangle1.getColor() + " triangle1 filled: " + triangle1.getFilled());

    }
}


class Triangle extends GeometricObject{
    private Double side1 = 1.0;
    private Double side2 = 1.0;
    private Double side3 = 1.0;

    public Triangle(){

    }
    
    public Triangle(Double side1, Double side2, Double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Double getSide1(){
        return side1;
    }

    public void setSide1(Double side1){
        this.side1 = side1;
    }

    public Double getSide2(){
        return side2;
    }

    public void setSide2(Double side2){
        this.side2 = side2;
    }

    public Double getSide3(){
        return side3;
    }

    public void setSide3(Double side3){
        this.side3 = side3;
    }

    @Override
    public double getArea(){
        Double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s* ((s - side1) * (s - side2) * ( s -side3)));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}