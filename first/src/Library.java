public class Library {
    String name ;
    int year;
    Book[]books; //library has book
    Library (String n,int y,Book[]b){
        name=n;
        year=y;
        books=b;
    }
    void displayInfo(){
        System.out.println(("The "+name+" has:"));
        for(Book book:books){
        System.out.println(book.displayInfo());
        }
    }
}
