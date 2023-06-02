class Product {
    private String Code;
    private String Description;
    private String ProductVAT;
    Product(String _Code, String _Description, String _ProductVAT) {
        Code = _Code;
        Description = _Description;
        ProductVAT = _ProductVAT;
    }
    void setCode(String _Code) {
        Code = _Code;
    }
    void setDescription(String _Description) {
        Description = _Description;
    }
    void setProductVAT(String _ProductVAT) {
        ProductVAT = _ProductVAT;
    }
    String getCode() {
        return Code;
    }
    String getDescription() {
        return Description;
    }
    String getProductVAT() {
        return ProductVAT;
    }
    public String toString() {
        return "Code: " + Code + "\nDescription: " + Description + "\nDistributor's VAT: " + ProductVAT;
    }
}
