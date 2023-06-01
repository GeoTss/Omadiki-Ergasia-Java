class WebAdType extends AdvertisementType{
    private static int currCode = 100;
    protected float CostPerDay, CostPerAdditionalPage, CostAutoShow;

    WebAdType(String _description, float _CostPerDay, float _CostPerAdditionalPage, float _CostAutoShow){
        code = currCode++;
        description = _description;
        CostPerDay = _CostPerDay;
        CostPerAdditionalPage = _CostPerAdditionalPage;
        CostAutoShow = _CostAutoShow;
    }

    void setCostPerDay(float _CostPerDay){
        CostPerDay = _CostPerDay;
    }

    void setCostPerAdditionalPage(int _CostPerAdditionalPage) {
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