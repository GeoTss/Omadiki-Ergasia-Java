abstract class Advertisement{
    String typeCode, productCode;
    // String VAT;
    String reason;
    protected int durationDays;

    void setProductCode(String code) {
        this.productCode = code;
    } 
    void setTypeCode(String code){
        typeCode = code;
    }
    void setDescritpion(String reason) {
        this.reason = reason;
    } 
    // void setVAT(String VAT) {
    //     this.VAT = VAT;
    // }
    String getProductCode() {
        return productCode;
    }
    String getTypeCode(){
        return typeCode;
    }
    String getreason() {
        return reason;
    }
    // String getVAT() {
    //     return VAT;
    // }

    public String toString(){
        return "Advertisement type code: " + typeCode + "\nProduct code: " + productCode + "\nAppearence duration in days: " + durationDays + "\nReason: " + reason;
    }

    abstract float calculateCost();
}