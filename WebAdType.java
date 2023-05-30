class WebAdType extends AdvertisementType{
    protected float CostPerDay, CostPerAdditionalPage, CostAutoShow;


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
}