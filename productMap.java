import java.util.HashMap;
public class productMap {
    HashMap<Product, adList> myHashMap = new HashMap<Product, adList>();
    public void insertCarrier(Product _Product, adList _adList) {
        myHashMap.put(_Product, _adList);
    }
}
