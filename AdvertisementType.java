abstract public class AdvertisementType{
    protected static int currCode = 100;
    protected int code;
    protected String description, carrier_VAT;

    int getCode() { return code; }
    String getDescription() { return description; }
    String getCarrierVAT(){ return carrier_VAT; }

    public String toString(){
        return "Code: " + code + "\nDescription: " + description; 
    }

}
