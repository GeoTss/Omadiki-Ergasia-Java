import java.util.ArrayList;
public class typeList {
    ArrayList<AdvertisementType> myArray = new ArrayList<AdvertisementType>();
    public void insertType(AdvertisementType _AdvertisementType) {
        myArray.add(_AdvertisementType);
    }
    public void displayTypeList() {
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println(myArray.get(i));
        }
    }
    public AdvertisementType get(int index) {
        return myArray.get(index);
    }
    public ArrayList<AdvertisementType> getArray() {
        return myArray;
    }
}

