import java.util.HashMap;
class carrierMap {
    HashMap<Carrier, adList> myHashMap = new HashMap<Carrier, adList>();
    public void insertCarrier(Carrier _Carrier, adList _adList) {
        myHashMap.put(_Carrier, _adList);
    }
}