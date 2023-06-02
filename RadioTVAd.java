class RadioTVAd extends Advertisement{
    private int timeZone;
    private int durationSeconds;
    private float timeZoneCPS;

    RadioTVAd(RadioTVAdType _info, Product _product, String _reason, int _durationDays, int _timeZone, int _durationSeconds){
        typeCode = _info.getCode();
        productCode = _product.getCode();
        reason = _reason;
        durationDays = _durationDays;
        // VAT = _info.getCarrierVAT();

        timeZone = _timeZone;
        durationSeconds = _durationSeconds;

        switch(timeZone){
            case 0:
                timeZoneCPS = _info.getcpsMorning();
                break;
            case 1:
                timeZoneCPS = _info.getcpsMidday();
                break;
            case 2:
                timeZoneCPS = _info.getcpsEvening();
                break;
            case 3:
                timeZoneCPS = _info.getcpsNight();
                break;
        }
    }

    RadioTVAd(RadioTVAdType _info, int _product, String _reason, int _durationDays, int _timeZone, int _durationSeconds){
        typeCode = _info.getCode();
        productCode = _product;
        reason = _reason;
        durationDays = _durationDays;
        // VAT = _info.getCarrierVAT();

        timeZone = _timeZone;
        durationSeconds = _durationSeconds;

        switch(timeZone){
            case 0:
                timeZoneCPS = _info.getcpsMorning();
                break;
            case 1:
                timeZoneCPS = _info.getcpsMidday();
                break;
            case 2:
                timeZoneCPS = _info.getcpsEvening();
                break;
            case 3:
                timeZoneCPS = _info.getcpsNight();
                break;
        }
    }

    void showCostFormula(){
        System.out.println("durationInSecondsForAD * timeZoneCostPerSecond * durationInDays = " + durationSeconds + " * " + timeZoneCPS + " * " + durationDays + " = " + (durationSeconds * timeZoneCPS * durationDays));
    }
    float calculateCost(){
        showCostFormula();
        return durationSeconds * timeZoneCPS * durationDays;
    }

    public String toStirng(){
        return super.toString() + "\nAdvertisement duration in seconds: " + durationSeconds + "\nTime zone: " + timeZone;
    }
}