import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class adList {
    ArrayList<Advertisement> myArrayList = new ArrayList<Advertisement>();

    adList(){
        myArrayList = new ArrayList<>();
    }

    adList(ArrayList<Advertisement> ads){
        myArrayList = ads;
    }

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
    public ArrayList<Advertisement> getArray() {
        return myArrayList;
    }

    void writeToFile(String filepath){
        try{
            FileWriter file = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(file);

            bw.write("ADV_LIST\n{\n");
            for(Advertisement ad: myArrayList)
                bw.write("\n\tADV\n\t{\n" + ad.genFileFormat() + "\n\t}\n");
            bw.write("\n}");

            bw.close();

        }catch(IOException ex){}
    }
}