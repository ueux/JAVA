public class Book {
    String title;
    int page;
    Book(String t, int p){
        title=t;
        page=p;
    }
    String displayInfo(){
        return title+"("+page+")";
    }

}
