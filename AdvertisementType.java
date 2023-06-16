abstract public class AdvertisementType{
    protected static int currCode = 100;
    protected int code;
    protected String description, carrier_VAT;

    int getCode() { return code; }
    String getDescription() { return description; }
    String getCarrierVAT(){ return carrier_VAT; }

    void setCode(int _code) { 
        code = _code;
        currCode = Integer.max(code, currCode)+1;
    }

    void setDescription(String _Description) { description = _Description; }
    void setCarrierVAT(String _carrier_VAT) { carrier_VAT = _carrier_VAT; }

    String genFileFormat(){
        return "CODE " + code + "\nAFM " + carrier_VAT + "\nDESCR \"" + description + "\"";
    }

    public String toString(){
        return "Code: " + code + "\nDescription: " + description; 
    }

}
