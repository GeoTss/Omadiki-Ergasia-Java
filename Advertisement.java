class Advertisement {
    String Code;
    String Description;
    String VAT;
    void setCode(String Code) {
        this.Code = Code;
    } 
    void setDescritpion(String Description) {
        this.Description = Description;
    } 
    void setVAT(String VAT) {
        this.VAT = VAT;
    }
    String getCode() {
        return Code;
    }
    String getDescription() {
        return Description;
    }
    String getVAT() {
        return VAT;
    }
    public String toString() {
        return "Code: " + Code + "\nDescription: " + Description + "\nVAT: " + VAT;
    }
}