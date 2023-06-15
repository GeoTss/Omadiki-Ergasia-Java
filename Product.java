class Product {
    static private int currCode = 0;
    private int Code;
    private String Description;
    private String ProductVAT;
    
    Product(String _Description, String _ProductVAT) {
        Code = currCode++;
        Description = _Description;
        ProductVAT = _ProductVAT;
    }

    Product() {}

    void setCode(int _Code){
        Code = _Code;
    }
    void setDescription(String _Description) {
        Description = _Description;
    }
    void setProductVAT(String _ProductVAT) {
        ProductVAT = _ProductVAT;
    }
    int getCode() {
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
