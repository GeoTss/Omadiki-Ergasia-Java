abstract class Advertisement{
    int typeCode, productCode;
    String reason;
    protected int durationDays;

    void setTypeCode(int code){
        typeCode = code;
    }
    void setDescritpion(String reason) {
        this.reason = reason;
    } 
    
    int getProductCode() {
        return productCode;
    }
    int getTypeCode(){
        return typeCode;
    }
    String getreason() {
        return reason;
    }

    public String toString(){
        return "Advertisement type code: " + typeCode + "\nProduct code: " + productCode + "\nAppearence duration in days: " + durationDays + "\nReason: " + reason;
    }

    abstract void showCostFormula();
    abstract float calculateCost();
}