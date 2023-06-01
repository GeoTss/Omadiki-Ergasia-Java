class Product {
    private String Code;
    private String Description;
    private String DistVAT;
    Product(String _Code, String _Description, String _DistVAT) {
        Code = _Code;
        Description = _Description;
        DistVAT = _DistVAT;
    }
    void setCode(String _Code) {
        Code = _Code;
    }
    void setDescription(String _Description) {
        Description = _Description;
    }
    void setDistVAT(String _DistVAT) {
        DistVAT = _DistVAT;
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
        return "Code: " + Code + "\nDescription: " + Description + "\nDistributor's VAT: " + DistVAT;
    }
}
