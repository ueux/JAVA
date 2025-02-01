public class Student extends Person{
    String name;
    int age;
    double gpa;
    boolean isEnrolled;

    static int numsOfStuds;

    //different parameter list
    Student(String name, int age, double gpa){
        super("Prashant","Verma"); // Using super the constructor of parent class with parameters is executed
        //needed when parent constructor consists of parameters
        this.name=name;
        this.age=age;
        this.gpa=gpa;
        this.isEnrolled=true;
        numsOfStuds++;
    }
    void study(){
        System.out.println(name+" is studying");
    }
    static void showStuds(){
        System.out.println("You have "+numsOfStuds+" Students");
    }
    void showTeacher(){
        System.out.println("Our class teacher is "+first+" "+last);
    }

    @Override
    void showName() {
        super.showName();
    }
    @Override
    public String toString(){
        return  name+" "+age+" "+gpa;
    }
}
