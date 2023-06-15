import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

public class AdvTypeWriter extends Writer<AdvertisementType> {
    protected AdvertisementType advtype;
    protected String Adtype;

    AdvTypeWriter(PrintedAdType _printedadtype) {
        advtype = _printedadtype;
        Adtype = "Print";
    }

    AdvTypeWriter(RadioTVAdType _radiotvadtype) {
        advtype = _radiotvadtype;
        Adtype = "RadioTV";
    }

    AdvTypeWriter(WebAdType _webadtype) {
        advtype = _webadtype;
        Adtype = "Web";
    }

    String getAdvertisementType() {
        return Adtype;
    }
    
    int getAdvertisementTypeCode() {
        return advtype.getCode();
    }

    String getAdvertisementTypeDesc() {
        return advtype.getDescription();
    }

    String getAdvertisementTypeVAT() {
        return advtype.getCarrierVAT();
    }

    void write(String filepath) {
        try {
            FileWriter file = new FileWriter(filepath);
            BufferedWriter _buff = new BufferedWriter(file);
            _buff.write("   ADV_TYPE\n  {");
            _buff.newLine();
            _buff.write("TYPE " + getAdvertisementType());
            _buff.newLine();
            _buff.write("CODE " + getAdvertisementTypeCode());
            _buff.newLine();
            _buff.write("DESCR" + getAdvertisementTypeDesc());
            _buff.newLine();
            _buff.write("AFM " + getAdvertisementTypeCode());
            _buff.newLine();
            if(Adtype == "Print") {
                _buff.write("COST_FRONT" + (PrintedAdType) advtype.getCostFront());
            }


            
            _buff.close();
        } catch(IOException ex) {
            ex.getStackTrace();
        }
    }
}
