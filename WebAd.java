public class WebAd extends Advertisement{
    protected boolean autoShow;
    protected int additionalPages;
    protected WebAdType typeInfo;

    WebAd(WebAdType _info, Product _product, String _reason, int _durationDays, boolean _autoShow, int _additionalPages){
        typeCode = _info.getCode();
        productCode = _product.getCode();
        reason = _reason;
        durationDays = _durationDays;
        VAT = _info.getCarrierVAT();
        
        autoShow = _autoShow;
        additionalPages = _additionalPages;

        typeInfo = _info;
        if(autoShow == false)
            typeInfo.CostAutoShow = 0;
    }

    WebAd(WebAdType _info, String _product, String _reason, int _durationDays, boolean _autoShow, int _additionalPages){
        typeCode = _info.getCode();
        productCode = _product;
        reason = _reason;
        durationDays = _durationDays;
        VAT = _info.getCarrierVAT();
        
        autoShow = _autoShow;
        additionalPages = _additionalPages;

        typeInfo = _info;
        if(autoShow == false)
            typeInfo.CostAutoShow = 0;
    }

    float calculateCost(){
        return typeInfo.getCostPerDay() * durationDays + typeInfo.getCostAutoShow() + typeInfo.getCostPerAdditionalPage() * additionalPages;
    }

    public String toString(){
        return super.toString() + "\nAdditional pages: " + additionalPages + "\nAuto show up: " + autoShow;
    }
}
