import java.util.ArrayList;
class carrierList {
    ArrayList<Carrier> myArray = new ArrayList<Carrier>();
    public void insertCarrier(Carrier _Carrier) {
        myArray.add(_Carrier);
    }
    public void displayCarrierList() {
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println(myArray.get(i) + "\n"); 
        }
    }
    public Carrier get(int index) {
        return myArray.get(index);
    }
    public ArrayList<Carrier> getArray() {
        return myArray;
    }
}