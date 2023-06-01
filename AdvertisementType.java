public class AdvertisementType{
    protected int code;
    protected String description, Supplier_VAT;

    int getCode(){
        return code;
    }
    public String toString(){
        return "Code: " + code + "\nDescription: " + description; 
    }
}
