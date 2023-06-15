import java.util.Scanner;

class WebAdType extends AdvertisementType{
    // private static int currCode = 100;
    protected float CostPerDay, CostPerAdditionalPage, CostAutoShow;

    WebAdType() {}

    WebAdType(String _description, Carrier _carrier, float _CostPerDay, float _CostPerAdditionalPage, float _CostAutoShow){
        code = currCode++;
        carrier_VAT = _carrier.getVAT();
        
        description = _description;
        CostPerDay = _CostPerDay;
        CostPerAdditionalPage = _CostPerAdditionalPage;
        CostAutoShow = _CostAutoShow;
    }

    WebAdType(String _description, String _carrier, float _CostPerDay, float _CostPerAdditionalPage, float _CostAutoShow){
        code = currCode++;
        carrier_VAT = _carrier;
        
        description = _description;
        CostPerDay = _CostPerDay;
        CostPerAdditionalPage = _CostPerAdditionalPage;
        CostAutoShow = _CostAutoShow;
    }

    WebAdType(String _description, String _carrier, Scanner scan){
        code = currCode++;
        carrier_VAT = _carrier;
        description = _description;

        System.out.println("Insert cost per day.");
        CostPerDay = scan.nextFloat();
        System.out.println("Insert cost per additional page.");
        CostPerAdditionalPage = scan.nextFloat();
        System.out.println("Insert cost of auto show.");
        CostAutoShow = scan.nextFloat();
    }

    void setCostPerDay(float _CostPerDay){
        CostPerDay = _CostPerDay;
    }

    void setCostPerAdditionalPage(float _CostPerAdditionalPage) {
        CostPerAdditionalPage = _CostPerAdditionalPage;
    }
    
    void setCostAutoShow(float _CostAutoShow){
        CostAutoShow = _CostAutoShow;
    }

    float getCostPerDay(){
        return CostPerDay;
    }

    float getCostPerAdditionalPage() {
        return CostPerAdditionalPage;
    }

    float getCostAutoShow(){
        return CostAutoShow;
    }

    public String toString(){
        return super.toString() + "\nCost per day: " + CostPerDay + "\nPrice for automatic show: " + CostAutoShow + "\nCost per additional page: " + CostPerAdditionalPage;
    }
}