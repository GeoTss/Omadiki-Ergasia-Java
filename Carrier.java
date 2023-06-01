class Carrier {
    private String VAT;
    private String Name;
    Carrier(String _VAT, String _Name) {
        VAT = _VAT;
        Name = _Name;
    }
    void setVAT(String _VAT) {
        VAT = _VAT;
    }
    void setName(String _Name) {
        Name = _Name;
    }
    String getVAT() {
        return VAT;
    }
    String getName() {
        return Name;
    }
    public String toString() {
        return "VAT: " + VAT + "\nName: " + Name;
    }
}