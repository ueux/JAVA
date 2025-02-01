public class Rectangle extends Shape{
    double length, width;
    Rectangle(double l, double w){
        width=w;
        length=l;
    }
    @Override
    double area() {
        return length*width;
    }
}
