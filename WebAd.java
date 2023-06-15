public class WebAd extends Advertisement{
    protected int autoShow;
    protected int additionalPages;
    protected WebAdType typeInfo;

    WebAd(WebAdType _info, Product _product, String _reason, int _durationDays, int _autoShow, int _additionalPages){
        typeCode = _info.getCode();
        productCode = _product.getCode();
        reason = _reason;
        durationDays = _durationDays;
        
        autoShow = _autoShow;
        additionalPages = _additionalPages;

        typeInfo = _info;
        if(autoShow == 0)
            typeInfo.CostAutoShow = 0;
    }

    WebAd(WebAdType _info, int _product, String _reason, int _durationDays, int _autoShow, int _additionalPages){
        typeCode = _info.getCode();
        productCode = _product;
        reason = _reason;
        durationDays = _durationDays;
        
        autoShow = _autoShow;
        additionalPages = _additionalPages;

        typeInfo = _info;
        if(autoShow == 0)
            typeInfo.CostAutoShow = 0;
    }

    void showCostFormula(){
        System.out.println("CostPerDay * durationInDays + CostForAutoShow (if activated) + CostPerAdditionalPages * AdditionalPages = " + typeInfo.getCostPerDay() + " * " + durationDays + " * " + typeInfo.getCostAutoShow() + " + " + typeInfo.getCostPerAdditionalPage() + " * " + additionalPages + " = " + (typeInfo.getCostPerDay() * durationDays + typeInfo.getCostAutoShow() + typeInfo.getCostPerAdditionalPage() * additionalPages));
    }
    float calculateCost(){
        showCostFormula();
        return typeInfo.getCostPerDay() * durationDays + typeInfo.getCostAutoShow() + typeInfo.getCostPerAdditionalPage() * additionalPages;
    }

    public String toString(){
        return super.toString() + "\nAdditional pages: " + additionalPages + "\nAuto show up: " + autoShow;
    }
}
