import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

class Stud implements Comparable<Stud>{
    int age;
    String name;
    public Stud(int a, String n){
        age=a;
        name=n;
    }
    @Override
    public String toString(){
        return "Student[age: "+age+",name: "+name+" ]";
    }
    @Override
    public int compareTo(Stud that){
        if(this.age>that.age)
            return 1;
        else
            return -1;
    }
}
public class CollectionApi {
    public static void main (String []args){
        //collection interface
        List<Integer>nums1=new ArrayList<>();
        Set<Integer>nums2=new HashSet<>();
        Set<Integer>nums3=new TreeSet<>();
        Map<String,Integer>nums4=new Hashtable<>();
        nums1.add(5);
        System.out.println(nums1.get(0));
//        for(Object n:nums){
//            int num=(Integer)n;
//            System.out.println(num);
//        }
        for(int n:nums1){
            System.out.println(n);
        }
//        Comparator<Stud> com=new Comparator<Stud>(){
//            @Override
//            public int compare(Stud i, Stud j){
//                if(i.age<j.age)
//                    return 1;
//                else
//                    return -1;
//            }
//        };
        //comparator is a functional interface
        Comparator<Stud> com=( i,  j)-> i.age<j.age?1:-1;

        List<Stud> studs=new ArrayList<>();
        studs.add(new Stud(21,"harsh"));
        studs.add(new Stud(19,"Anami"));
        studs.add(new Stud(20,"Gau"));
        studs.add(new Stud(22,"Gah"));
        Collections.sort(studs);
        System.out.println("With Comparable class");
        for(Stud s:studs)
            System.out.println(s);
        Collections.sort(studs,com);
        System.out.println("With Comparator class");
        for(Stud s:studs)
            System.out.println(s);

        List<Integer>nums=Arrays.asList(4,5,87,52,5,12);

        //for each loop
//        Consumer<Integer>con=new Consumer<Integer>() {
//            @Override
//            public void accept(Integer n) {
//                System.out.println(n);
//            }
//        };
//        Consumer - functional interface
//        Consumer<Integer>con= n -> System.out.println(n);
//        nums.forEach(con);
        nums.forEach(n->System.out.println(n));

        //Steam Api
        Stream<Integer> s1=nums.stream(); //we can perform anything on s1 and doesn't affect nums
////        can only use once
//        s1.forEach(System.out::println);
////        s1.forEach(n->System.out.println(n));
        Stream<Integer>s2=s1.filter(n->n%2==0);
//        s2.forEach(n->System.out.println(n));
        Stream<Integer>s3=s2.map(n->n*2);
//        s3.forEach(n->System.out.print(n+" "));
        int result1=s3.reduce(0,(c,e)->c+e); //identity- initial value , c,e- continues values, binary operations on c,e
        System.out.println(result1);

        // one-liner
        int result2=nums.stream()
                .filter(n->n%2==0)
                .map(n->n*2)
                .reduce(0,(c,e)->c+e);
        System.out.println(result2);

        Stream<Integer> sortedValues=nums.stream()
                .filter(n->n%2==0)
                        .sorted();
        sortedValues.forEach(n->System.out.print(n+" "));
        System.out.println();
        //parallel stream for filter

        System.out.println(nums);

    }
}
