class Carrier {
    private String VAT;
    private String Name;
    void setVAT(String VAT) {
        this.VAT = VAT;
    }
    void setName(String Name) {
        this.Name = Name;
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