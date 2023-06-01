public class App {
  public static void main(String[] args) {
    carrierList _carrierList = new carrierList();
    _carrierList.insertCarrier(new Carrier("1234", "Giwrgos"));
    _carrierList.insertCarrier(new Carrier("5678", "Vasilis"));
    _carrierList.insertCarrier(new Carrier("1312", "Filippos"));
    _carrierList.insertCarrier(new Carrier("6969", "Antonis"));
    productList _productList = new productList();
    _productList.insertProduct(new Product("CoDe", "DeScRiPtIoN", "1234"));
    _productList.insertProduct(new Product("Hello", "IDK", "1212"));
    _productList.insertProduct(new Product("World", "null", "2069"));
    _productList.insertProduct(new Product("ARDVARG", "Pays off", "1821"));
    typeList _typeList = new typeList();
    _typeList.insertType(new PrintedAdType("get rekt", 3.14f, 6.28f, 9.42f));
    _typeList.insertType(new PrintedAdType("I am not a god, i am not a king, i am... worse", 3.03f, 8.18f, 10.02f));
    _typeList.insertType(new PrintedAdType("frontises smr", 15f, 60f, 28f));
    _typeList.insertType(new RadioTVAdType("o pappas o paxus", 1f, 2f, 3f, 4f));
    _typeList.insertType(new RadioTVAdType("paei o palios o xronos", 2f, 4f, 6f, 8f));
    _typeList.insertType(new RadioTVAdType("ela re ti leei", 5f, 10f, 15f, 20f));
    _typeList.insertType(new WebAdType("Giannhs", 2f, 6f, 10f));
    _typeList.insertType(new WebAdType("Giannakhs", 29f, 43f, 10f));
    _typeList.insertType(new WebAdType("Giannaras", 8f, 11.880f, 9.11f));
  }
}
