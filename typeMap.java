import java.util.HashMap;
public class typeMap {
    HashMap<AdvertisementType, adList> myHashMap = new HashMap<AdvertisementType, adList>();
    public void insertType(AdvertisementType _AdvertisementType, adList _adList) {
        myHashMap.put(_AdvertisementType, _adList);
    }
}

