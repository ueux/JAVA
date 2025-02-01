public class Product <T,U>{
    T item;
    U price;
    Product(T i, U p){
        item=i;
        price=p;
    }
    public T getItem(){
        return item;
    }
    public U getPrice(){
        return price;
    }
}
