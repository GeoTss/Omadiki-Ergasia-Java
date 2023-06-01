abstract public class AdvertisementType{
    protected int code;
    protected String description, carrier_VAT;

    int getCode(){ return code; }

    String getCarrierVAT(){ return carrier_VAT; }

    public String toString(){
        return "Code: " + code + "\nDescription: " + description; 
    }
}
