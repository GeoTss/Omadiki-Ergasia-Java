import java.util.ArrayList;
public class typeList {
    ArrayList<AdvertisementType> myArray = new ArrayList<AdvertisementType>();
    public void insertType(AdvertisementType _AdvertisementType) {
        myArray.add(_AdvertisementType);
    }
    public AdvertisementType get(int index) {
        return myArray.get(index);
    }
}

