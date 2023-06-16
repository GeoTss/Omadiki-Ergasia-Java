import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class typeList {
    ArrayList<AdvertisementType> myArray;

    typeList(ArrayList<AdvertisementType> l){
        myArray = l;
    }

    typeList() {
        myArray = new ArrayList<AdvertisementType>();
    }

    public void insertType(AdvertisementType _AdvertisementType) {
        myArray.add(_AdvertisementType);
    }
    public void displayTypeList() {
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println(myArray.get(i) + "\n");
        }
    }
    public AdvertisementType get(int index) {
        return myArray.get(index);
    }
    public ArrayList<AdvertisementType> getArray() {
        return myArray;
    }

    void writeToFile(String filepath){
        try{
            FileWriter file = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(file);

            bw.write("ADVTYPE_LIST\n{\n");
            for(AdvertisementType adType: myArray)
                bw.write("\n\tADVTYPE\n\t{\n" + adType.genFileFormat() + "\n\t}\n");
            bw.write("\n}");

            bw.close();

        }catch(IOException ex){}
    }
}

