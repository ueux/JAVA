public class Cars {
    String model;
    int year;
    Engine engine;
    Cars(String m,int y, String engineType){
        model=m;
        year=y;
        engine=new Engine(engineType);
    }
}
