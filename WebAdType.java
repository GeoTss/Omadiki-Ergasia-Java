class WebAdType extends AdvertisementType{
    protected float CostPerDay;
    protected int CostPerPage;

    void setCostPerDay(float _CostPerDay){
        CostPerDay = _CostPerDay;
    }

    void setCostPerPage(int CostPerPage) {
        this.CostPerPage = CostPerPage;
    }
    
    float getCostPerDay(){
        return CostPerDay;
    }

    int getCostPerPage() {
        return CostPerPage;
    }
}