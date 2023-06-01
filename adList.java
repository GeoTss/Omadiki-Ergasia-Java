import java.util.ArrayList;
public class adList {
    ArrayList<Advertisement> myArrayList = new ArrayList<Advertisement>();
    public void insertAd(Advertisement _Advertisement) { 
        myArrayList.add(_Advertisement);
    }
    public void displayAdList() {
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i) + "\n");
        }
    }
    public Advertisement get(int index) {
        return myArrayList.get(index);
    }
}