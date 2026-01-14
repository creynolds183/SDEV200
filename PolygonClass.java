public class PolygonClass {
    public static void main(String[] args){
        RegularPolygon p1 = new RegularPolygon();
        RegularPolygon p2 = new RegularPolygon(6, 4);
        RegularPolygon p3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println(p1.GetPerimeter());
        System.out.println(p1.GetArea());

        System.out.println(p2.GetPerimeter());
        System.out.println(p2.GetArea());

        System.out.println(p3.GetPerimeter());
        System.out.println(p3.GetArea());
    }
}

class RegularPolygon {
    private int n = 3;
    private double side = 1.0;
    private double x = 0;
    private double y = 0;

    RegularPolygon() {
    }

    RegularPolygon(int newN, double newSide) {
        n = newN;
        side = newSide;
    }

    RegularPolygon(int newN, double newSide, double newX, double newY) {
        n = newN;
        side = newSide;
        x = newX;
        y = newY;
    }

    int GetN() {
        return n;
    }

    double GetSide() {
        return side;
    }

    double GetX() {
        return x;
    }

    double GetY() {
        return y;
    }

    double GetPerimeter(){
        return n * side;
    }

    double GetArea(){
        return (n * (side * side)) / (4 * (Math.tan(Math.PI / n)));
    }

    void SetN(int newN) {
        n = newN;
    }

    void SetSide(double newSide) {
        side = newSide;
    }

    void SetX(double newX) {
        x = newX;
    }

    void SetY(double newY) {
        y = newY;
    }


}