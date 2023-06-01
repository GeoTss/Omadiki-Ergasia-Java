public class WebAd extends Advertisement{
    protected boolean autoShow;
    protected int additionalPages;
    protected WebAdType typeInfo;

    WebAd(WebAdType _info, int _productCode, String _reason, int _durationDays, boolean _autoShow, int _additionalPages){
        typeCode = _info.getCode();
        productCode = _productCode;
        reason = _reason;
        durationDays = _durationDays;
        
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
        return super.toString() + "\nAdditional pages: " + additionalPages + "Auto show up: " + autoShow;
    }
}
