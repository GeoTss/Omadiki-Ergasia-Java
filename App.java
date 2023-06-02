import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class App {
  public static void greetUser() {
    System.out.println(
        "Type 1 to add a new carrier.\nType 2 to add a new Advertisement type.\nType 3 to add a new Advertisement.\nType 4 to display Advertisements.\nType 5 to display Advertisements of a certain Carrier.\nType 6 to evaluate the cost of all the Advertisements of a certain carrier.\nType 7 to display the count of Advertisements per Product.\nType 8 to evaluate the cost of the Advertisement of a single Product.\nType 9 to display the cost of the Advertisements per Product.\nType 0 to exit the application.");
  }
  public static boolean checkWordCount(int _wordCount) {
    return (_wordCount > 0);
  }
  public static boolean checkPosition(int _position) {
    return ((_position >= 0) && (_position <= 2));
  }
  public static boolean checkDuration(int _duration) {
    return _duration > 0;
  }
  public static boolean checkAdditionalPages(int _additionalPages) {
    return _additionalPages > 0;
  }
  public static boolean checkTimeZone(int _timeZone) {
    return ((_timeZone >= 0) && (_timeZone <= 3));
  }
  public static boolean checkDurationSeconds(int _durationSeconds) {
    return (_durationSeconds > 0); 
  }
  public static boolean checkAutoShow(int _autoshow) {
    return ((_autoshow >= 1) && (_autoshow <= 2));
  }
  public static void wrongInput() {
    System.out.println("Wrong input please try again.");
  }

  public static void main(String[] args) {
    carrierList _carrierList = new carrierList();
    _carrierList.insertCarrier(new Carrier("1234", "Giwrgos"));
    _carrierList.insertCarrier(new Carrier("5678", "Vasilis"));
    _carrierList.insertCarrier(new Carrier("1312", "Filippos"));
    _carrierList.insertCarrier(new Carrier("6969", "Antonis"));
    productList _productList = new productList();
    _productList.insertProduct(new Product("DeScRiPtIoN", "1234"));
    _productList.insertProduct(new Product("IDK", "5678"));
    _productList.insertProduct(new Product("null", "6969"));
    _productList.insertProduct(new Product("Pays off", "1312"));
    typeList _typeList = new typeList();
    _typeList.insertType(new PrintedAdType("get rekt", _carrierList.myArray.get(1), 3.14f, 6.28f, 9.42f));
    _typeList.insertType(new PrintedAdType("I am not a god, i am not a king, i am... worse", _carrierList.myArray.get(0), 3.03f, 8.18f, 10.02f));
    _typeList.insertType(new PrintedAdType("frontises smr", _carrierList.myArray.get(0), 15f, 60f, 28f));
    _typeList.insertType(new RadioTVAdType("o pappas o paxus", _carrierList.myArray.get(0), 1f, 2f, 3f, 4f));
    _typeList.insertType(new RadioTVAdType("paei o palios o xronos", _carrierList.myArray.get(1), 2f, 4f, 6f, 8f));
    _typeList.insertType(new RadioTVAdType("ela re ti leei", _carrierList.myArray.get(1), 5f, 10f, 15f, 20f));
    _typeList.insertType(new WebAdType("Giannhs", _carrierList.myArray.get(2), 2f, 6f, 10f));
    _typeList.insertType(new WebAdType("Giannakhs", _carrierList.myArray.get(2), 29f, 43f, 10f));
    _typeList.insertType(new WebAdType("Giannaras", _carrierList.myArray.get(3), 8f, 11.880f, 9.11f));
    adList _adList = new adList();
    _adList.insertAd(
        new PrintedAd((PrintedAdType) _typeList.get(0), _productList.myList.get(0), "kys", 10, 100, 1));
    _adList
        .insertAd(new PrintedAd((PrintedAdType) _typeList.get(1), _productList.myList.get(0), "syk", 8, 105, 0));
    _adList.insertAd(new PrintedAd((PrintedAdType) _typeList.get(2), _productList.myList.get(1),
        "i have commited several warcrimes", 5, 50, 2));
    _adList.insertAd(
        new PrintedAd((PrintedAdType) _typeList.get(2), _productList.myList.get(1), "no reason", 100, 2, 1));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(4), _productList.myList.get(1), "i just had to do it",
        10, 0, 60));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(5), _productList.myList.get(2), "i am tired of typing",
        30, 1, 10));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(5), _productList.myList.get(3), "the mentor approves",
        101, 2, 610));
    _adList.insertAd(
        new RadioTVAd((RadioTVAdType) _typeList.get(4), _productList.myList.get(3), "madclip leipeis", 1, 3, 17));
    _adList
        .insertAd(new WebAd((WebAdType) _typeList.get(8), _productList.myList.get(2), "javac App.java", 10, 1, 2));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(6), _productList.myList.get(2), "java App", 11, 2, 10));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(7), _productList.myList.get(3),
        "App.java:44: error: constructor WebAd in class WebAd cannot be applied to given types;", 101, 1, 22));
    _adList.insertAd(
        new WebAd((WebAdType) _typeList.get(8), _productList.myList.get(3), "insert lenny face here", 165, 2, 80));

    HashMap<String, ArrayList<Advertisement>> carrierMem = new HashMap<String, ArrayList<Advertisement>>();
    HashMap<Integer, ArrayList<Advertisement>> productMem = new HashMap<Integer, ArrayList<Advertisement>>();
    HashMap<Integer, AdvertisementType> codeMem = new HashMap<Integer, AdvertisementType>();
    // HashMap<Integer, Product> productMem = new HashMap<Integer, Product>();

    for(AdvertisementType ty: _typeList.getArray())
      codeMem.put(ty.getCode(), ty);

    for (Carrier c : _carrierList.getArray()) {
      carrierMem.put(c.getVAT(), new ArrayList<Advertisement>());
    }

    for (Product p : _productList.myList)
      productMem.put(p.getCode(), new ArrayList<Advertisement>());

    for (Advertisement ad : _adList.getArray()) {
      carrierMem.get(codeMem.get(ad.getTypeCode()).getCarrierVAT()).add(ad);
      productMem.get(ad.getProductCode()).add(ad);
    }

    Scanner scan = new Scanner(System.in);
    greetUser();
    int answer = scan.nextInt();
    while ((answer > 0) && (answer <= 9)) {
      switch (answer) {
        case 1:
          System.out.println("Insert VAT and Name of the new Carrier");
          _carrierList.insertCarrier(new Carrier(scan.next(), scan.next()));
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
            default:
              wrongInput();
              break;
          }
          break;
        case 3:
          _typeList.displayTypeList();
          int _TypeCode;
          do {
            _TypeCode = scan.nextInt();
          } while (!codeMem.containsKey(_TypeCode));       
            _productList.displayProductList();
          int _ProductCode;
          do {
            _ProductCode = scan.nextInt();
          } while (!productMem.containsKey(_ProductCode));
          System.out.println("Insert duration of days");
          int _Duration;
          do {   
            _Duration = scan.nextInt();
          } while (!checkDuration(_Duration));
          System.out.println("Insert reason.");
          String _reason = scan.nextLine();
          AdvertisementType _Type = codeMem.get(_TypeCode);
          if (_Type instanceof PrintedAdType) {
            System.out.println("Insert word count.");
            int _wordCount;
            do {
              _wordCount = scan.nextInt();
            } while (!checkWordCount(_wordCount));
              System.out.println("Insert position.");
            int _position;
            do {
              _position = scan.nextInt();
            } while (!checkPosition(_position));
            _adList.insertAd(
                new PrintedAd((PrintedAdType) _Type, _ProductCode, _reason, _Duration, _wordCount, _position));
          } else if (_Type instanceof RadioTVAdType) {
            System.out.println("Insert auto show.");
            int _autoshow;
            do {
              _autoshow = scan.nextInt();
            } while (!checkAutoShow(_autoshow));
            System.out.println("Insert additional pages.");
            int _additionalPages;
            do {
              _additionalPages = scan.nextInt();
            } while (!checkAdditionalPages(_additionalPages));
              _adList
                .insertAd(new WebAd((WebAdType) _Type, _ProductCode, _reason, _Duration, _autoshow, _additionalPages));
          } else if (_Type instanceof WebAdType){
            System.out.println("Insert time zone.");
            int _TimeZone;
            do {
              _TimeZone = scan.nextInt();
            } while (!checkTimeZone(_TimeZone));
            System.out.println("");
            int _DurationSeconds = scan.nextInt();
            _adList.insertAd(
                new RadioTVAd((RadioTVAdType) _Type, _ProductCode, _reason, _Duration, _TimeZone, _DurationSeconds));
          } else {
            wrongInput();
          }
          break;
        case 4:
          _adList.displayAdList();
          break;
        case 5:
          String vat;
          do {
            System.out.println("Insert the VAT of the carrier.");
            vat = scan.next();
          } while (!carrierMem.containsKey(vat));

          for (Advertisement ad : carrierMem.get(vat)) {
            System.out.println(ad);
          }
          break;

        case 6:
          String vatCalcCost;
          do{
          System.out.println("Insert the VAT of the carrier.");
          vatCalcCost = scan.next();
          }while(!carrierMem.containsKey(vatCalcCost));

          float sum = 0;
          for (Advertisement ad : carrierMem.get(vatCalcCost)) {
            sum += ad.calculateCost();
          }
          System.out.println(sum);
          break;

        case 7:
          // System.out.println("Insert the code of the product.");
          // int code = scan.nextInt();
          class productPair {
            private Product pr;
            private int count;

            Product getProduct() {
              return pr;
            }

            int getCount() {
              return count;
            }

            productPair(Product _pr, int _count) {
              pr = _pr;
              count = _count;
            }
          }
          ;

          ArrayList<productPair> productCount = new ArrayList<productPair>();
          for (Product pr : _productList.myList)
            productCount.add(new productPair(pr, productMem.get(pr.getCode()).size()));

          Comparator<productPair> productPairComparator = (productPair p1, productPair p2) -> Integer
              .compare(p2.getCount(), p1.getCount());
          productCount.sort(productPairComparator);

          for (productPair p : productCount) {
            System.out.println("Product:\n" + p.getProduct() + "\nCount: " + p.getCount() + "\n");
            System.out.println("-----------------------------------------------");
          }

          break;
        case 8:
          break;
        case 9:
          class CostPair {
            private Product pr;
            private float totalCost;

            Product getProduct() {
              return pr;
            }

            float getTotalCost() {
              return totalCost;
            }

            CostPair(Product _pr, float _totalCost) {
              pr = _pr;
              totalCost = _totalCost;
            }
          };

          ArrayList<CostPair> productCost = new ArrayList<CostPair>();
          for (Product pr : _productList.myList) {
            float _sum = 0;
            for (Advertisement ad : productMem.get(pr.getCode()))
              _sum += ad.calculateCost();
            productCost.add(new CostPair(pr, _sum));
          }

          Comparator<CostPair> CostPairComparator = (CostPair p1, CostPair p2) -> Float.compare(p2.getTotalCost(),
              p1.getTotalCost());
          productCost.sort(CostPairComparator);

          for (CostPair p : productCost) {
            System.out.println("Product:\n" + p.getProduct() + "\nTotal cost: " + p.getTotalCost() + "\n");
            System.out.println("-----------------------------------------------");
          }

          break;
        default:
          wrongInput();
          break;
      }
      greetUser();
      answer = scan.nextInt();
    }
    scan.close();

  }
}
