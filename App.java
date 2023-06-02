import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
  public static void greetUser() {
    System.out.println("Type 1 to add a new carrier.\nType 2 to add a new Advertisement type.\nType 3 to add a new Advertisement.\nType 4 to display Advertisements.\nType 5 to display Advertisements of a certain Carrier.\nType 6 to evaluate the cost of all the Advertisements of a certain carrier.\nType 7 to display the count of Advertisements per Product.\nType 8 to evaluate the cost of the Advertisement of a single Product.\nType 9 to display the cost of the Advertisements per Product.\nType 0 to exit the application.");
  }
  public static void main(String[] args) {
    carrierList _carrierList = new carrierList();
    _carrierList.insertCarrier(new Carrier("1234", "Giwrgos"));
    _carrierList.insertCarrier(new Carrier("5678", "Vasilis"));
    _carrierList.insertCarrier(new Carrier("1312", "Filippos"));
    _carrierList.insertCarrier(new Carrier("6969", "Antonis"));
    productList _productList = new productList();
    _productList.insertProduct(new Product("CoDe", "DeScRiPtIoN", "1234"));
    _productList.insertProduct(new Product("Hello", "IDK", "5678"));
    _productList.insertProduct(new Product("World", "null", "6969"));
    _productList.insertProduct(new Product("ARDVARG", "Pays off", "1312"));
    typeList _typeList = new typeList();
    _typeList.insertType(new PrintedAdType("get rekt", _carrierList.myArray.get(1), 3.14f, 6.28f, 9.42f));
    _typeList.insertType(new PrintedAdType("I am not a god, i am not a king, i am... worse",  _carrierList.myArray.get(0), 3.03f, 8.18f, 10.02f));
    _typeList.insertType(new PrintedAdType("frontises smr",  _carrierList.myArray.get(0), 15f, 60f, 28f));
    _typeList.insertType(new RadioTVAdType("o pappas o paxus",  _carrierList.myArray.get(0), 1f, 2f, 3f, 4f));
    _typeList.insertType(new RadioTVAdType("paei o palios o xronos",  _carrierList.myArray.get(1),2f, 4f, 6f, 8f));
    _typeList.insertType(new RadioTVAdType("ela re ti leei", _carrierList.myArray.get(1), 5f, 10f, 15f, 20f));
    _typeList.insertType(new WebAdType("Giannhs",  _carrierList.myArray.get(2), 2f, 6f, 10f));
    _typeList.insertType(new WebAdType("Giannakhs",  _carrierList.myArray.get(2), 29f, 43f, 10f));
    _typeList.insertType(new WebAdType("Giannaras",  _carrierList.myArray.get(3), 8f, 11.880f, 9.11f));
    adList _adList = new adList();
    _adList.insertAd(new PrintedAd((PrintedAdType) _typeList.get(0), _productList.myList.get(0), "kys", 10, 100, "middle"));
    _adList.insertAd(new PrintedAd((PrintedAdType) _typeList.get(1), _productList.myList.get(0), "syk", 8, 105, "front"));
    _adList.insertAd(new PrintedAd((PrintedAdType) _typeList.get(2), _productList.myList.get(1), "i have commited several warcrimes", 5, 50, "back"));
    _adList.insertAd(new PrintedAd((PrintedAdType) _typeList.get(2), _productList.myList.get(1), "no reason", 100, 2, "middle"));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(4), _productList.myList.get(1), "i just had to do it", 10, "morning", 60));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(5), _productList.myList.get(2), "i am tired of typing", 30, "midday", 10));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(5), _productList.myList.get(3), "the mentor approves", 101, "evening", 610));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(4), _productList.myList.get(3), "madclip leipeis", 1, "night", 17));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(8), _productList.myList.get(2), "javac App.java", 10, true, 2));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(6), _productList.myList.get(2), "java App", 11, false, 10));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(7), _productList.myList.get(3), "App.java:44: error: constructor WebAd in class WebAd cannot be applied to given types;", 101, true, 22));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(8), _productList.myList.get(3), "insert lenny face here", 165, false, 80));
    

    HashMap<String, ArrayList<Advertisement>> carrierMem = new HashMap<String, ArrayList<Advertisement>>();
    HashMap<String, ArrayList<Advertisement>> productMem = new HashMap<String, ArrayList<Advertisement>>();
    HashMap<Integer, AdvertisementType> codeMem = new HashMap<Integer, AdvertisementType>();

    for(Carrier c: _carrierList.myArray){
      carrierMem.put(c.getVAT(), new ArrayList<Advertisement>());
    }

    for(Product p: _productList.myList)
      productMem.put(p.getCode(), new ArrayList<Advertisement>());

    for(Advertisement ad: _adList.myArrayList){
      carrierMem.get(ad.getVAT()).add(ad);
      productMem.get(ad.getProductCode()).add(ad);
    }

    for(AdvertisementType ty: _typeList.myArray) {
      codeMem.put(ty.getCode(), ty);
    }
    
    Scanner scan = new Scanner(System.in);
    greetUser();
    int answer = scan.nextInt();
    while ((answer > 0) && (answer <= 9)) {
      switch (answer) {
        case 1:
          System.out.println("Insert VAT and Name of the new Carrier");
          _carrierList.insertCarrier(new Carrier(scan.next(),scan.next()));
          break;
        case 2:
          System.out.println("Insert 1 for PrintedAd type, 2 for RadioTVAdtype , 3 for WebAd type.");
          int choice2 = scan.nextInt();
          System.out.println("Insert description.");
          String _Description = scan.nextLine();
          System.out.println("Insert VAT of carrier.");
          String _VAT = scan.next();
          switch (choice2) {
            case 1:
              _typeList.insertType(new PrintedAdType(_Description, _VAT, scan));
              break;
            case 2:
              _typeList.insertType(new RadioTVAdType(_Description, _VAT, scan));
              break;
            case 3:
              _typeList.insertType(new WebAdType(_Description, _VAT, scan));
              break;
          }
          break;
        case 3:
          _typeList.displayTypeList();
          int _TypeCode = scan.nextInt();
          _productList.displayProductList();
          String _ProductCode = scan.next();
          System.out.println("Insert duration of days");
          int _Duration = scan.nextInt();
          System.out.println("Insert reason.");
          String _reason = scan.nextLine();
          AdvertisementType _Type = codeMem.get(_TypeCode);
          if (_Type instanceof PrintedAdType) {
            System.out.println("Insert word count.");
            int _wordCount = scan.nextInt();
            System.out.println("Insert position.");
            String _position = scan.next();
            _adList.insertAd(new PrintedAd((PrintedAdType) _Type, _ProductCode, _reason, _Duration, _wordCount, _position));
          } else if (_Type instanceof RadioTVAdType) {
            System.out.println("Insert auto show. (true or false)");
            boolean _autoshow = scan.nextBoolean();
            System.out.println("Insert additional pages.");
            int _additionalPages = scan.nextInt();
            _adList.insertAd(new WebAd((WebAdType) _Type, _ProductCode, _reason, _Duration, _autoshow, _additionalPages));
          } else {
            System.out.println("Insert time zone.");
            String _TimeZone = scan.next();
            System.out.println("");
            int _DurationSeconds = scan.nextInt();
            _adList.insertAd(new RadioTVAd((RadioTVAdType) _Type, _ProductCode, _reason, _Duration, _TimeZone, _DurationSeconds));
          }
          break;
        case 4:
          _adList.displayAdList();
          break;
        case 5:
          {
          System.out.println("Insert the VAT of the carrier.");
          String _VATC = scan.next();
          for (Advertisement ad: carrierMem.get(_VATC)) {
            System.out.println(ad);
          }
          break;
          }
        case 6:
          {
          System.out.println("Insert the VAT of the carrier.");
          String _VATC = scan.next();
          float sum = 0;
          for (Advertisement ad: carrierMem.get(_VATC)) {
            sum += ad.calculateCost();
          }
          System.out.println(sum);
          break;
          }
        case 7:
          System.out.println("Insert the code of the product.");
          String _Code = scan.next();
          int count = 0;
          for (Advertisement ad: carrierMem.get(_Code)) {
            count++;
          }
          System.out.println(count);
          break;
        case 8:
          
          break;
        case 9:
          
          break;
      }
      greetUser();
      answer = scan.nextInt();
    }
    scan.close();
  
  }
}
