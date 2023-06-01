import java.util.ArrayList;
public class productList {
    ArrayList<Product> myList = new ArrayList<Product>();
    public void insertProduct(Product _Product) {
        myList.add(_Product);
    }
    public Product get(int index) {
        return myList.get(index);
    }
    public ArrayList<Product> getArray() {
        return myList;
    }
}
