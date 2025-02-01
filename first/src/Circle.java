public class Circle extends Shape{
    double radius;
    Circle(double r){
        radius=r;
    }
    @Override
    double area() {
        return Math.PI*radius*radius;
    }
}
