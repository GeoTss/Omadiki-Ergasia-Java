class Product {
    private String Code;
    private String Description;
    private String DistVAT;
    void setCode(String Code) {
        this.Code = Code;
    }
    void setDescription(String Description) {
        this.Description = Description;
    }
    void setDistVAT(String DistVAT) {
        this.DistVAT = DistVAT;
    }
    String getCode() {
        return Code;
    }
    String getDescription() {
        return Description;
    }
    String getDistVAT() {
        return DistVAT;
    }
    public String toString() {
        return "Code: " + Code + "\nDescription: " + Description + "\n Distributor's VAT: " + DistVAT;
    }
}
