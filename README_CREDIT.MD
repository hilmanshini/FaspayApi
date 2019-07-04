# Faspay SDK CREDIT




What will you need know  for develop this SDK is that ^[this Credit payment need a browser to run] so most likely you need a thick client like smartphone or desktop in order to run this SDK




# User Object

just like debit payment, this SDK needs user object, 

```groovy
    public class TestUserBaruCredit extends FaspayUserCredit{

        public TestUserBaruCredit() {
            setMerchantId("######");
            setPass("abcde");
        }



    }

```



# Faspay Credit Create Payment
just like debit function, this function create the payment but user must fill the form of html 

```java
    //sample code
    
        //from previous code 
        FaspayUserCredit usr = new TestUserBaruCredit();
                //create wrapper
                FaspayPaymentCreditWrapperProd w = new FaspayPaymentCreditWrapperProd(usr,
                new FaspayPaymentCreditTransactionData(usr, UUID.randomUUID().toString().replaceAll("-", ""), "IDR", 10000),
                //create shopper data, AND FILL ALL
                new FaspayPaymentCreditShopperData("ha", "ha@ha.com",
                        "123123123123", "123123", "5123456789012346", "123123",
                        CARD_TYPE_VISA, 10, "2020", "123123"),
//create Config app with URL NOTIFY FROM DEBIT SECTION
                new FaspayPaymentCreditConfigApp(RESPONSE_TYPE_POST, "<<URL NOTIFY>>"),
//create bill description data, AND FILL ALL
                new FaspayPaymentCreditBillData("123", "123", "123", "123", "123", "ID"),
//create bill shipping data data, AND FILL ALL
                new FaspayPaymentCreditShippingdata("5", "5", "5", "5", "5", "5", 0),
//create item description, MAXIMUM 10 items, you can create it with constructor
                new FaspayPaymentCreditItemData("<<ITEM1>>","<<ITEM2>>","<<ITEM3>>"),
//create domicile data, ignore the fields or fill it if you want it, its not necessary
                new FaspayPaymentCreditDomicileData(),
//create credit card data, its not necessary
                new FaspayPaymentCreditCardData());


        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");

            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(w.generateHtml().getBytes());
            fos.flush();
            fos.close();
            System.out.println(temp.getAbsolutePath());
           openFile(temp);
        } catch (IOException ex) {
            Logger.getLogger(TestCreatePayment.class.getName()).log(Level.SEVERE, null, ex);
        }
```

this example will show the HTML of your browser via desktop platform, in android you can use WebView

# Faspay Credit Capture Payment
```java
    String html = new CaptureRequestWrapperProd(new TestUserBaruCredit(), "c0f4dbe47d27490e81a03ee771be6b47", "110B90DB-DA6C-4FEC-8ACD-C1DBF78A2E61", 10000, "ha", "haha@haha.com", "ddddd ", "<<URL NOTIFY>>").generateHtml();
        try {
            File temp = File.createTempFile(UUID.randomUUID().toString(), ".html");

            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(html.getBytes());
            fos.flush();
            fos.close();
            System.out.println();
            System.out.println(temp.getAbsolutePath());
           // openFile(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
```

this example will show the HTML of your browser via desktop platform, in android you can use WebView


# Faspay Credit Inquiry  Payment

this example will generate the HTML of your browser via desktop platform, in android you can use WebView

```java
    FaspayConfigCredit conf = new FaspayConfigCreditProd();
    FaspayUserCredit credit = new TestUserBaruCredit();
    InquiryRequestCredit d = new InquiryRequestCreditWrapper(conf, credit, "e5f95232e08446cabda1b10ce6deb579", 10000);
    d.generateHtml()
```



# Faspay Credit Refund  Payment
this example will generate the HTML of your browser via desktop platform, in android you can use WebView
```java
String html = new RefundRequestWrapperProd(new TetsUser2(), "64ddf6a2dc1347dca59c029e8ea52e30", "FA9A8C87-A5C0-480C-88E2-1C48DC0D55B9", 100000, "merhcant test CC", "haha@haha.com", "ddddd ", "<<URL NOTIFY>>", 100000).generateHtml();
```



# Faspay Credit Void  Payment
```java
this example will generate the HTML of your browser via desktop platform, in android you can use WebView
# Faspay Credit Void  Payment
String html = new VoidRequestWrapperProd(new TestUserBaruCredit(), "e5f95232e08446cabda1b10ce6deb579", "042621B9-0FE3-4FDD-9350-97A4C931FF85", 10000, "ha", "haha@haha.com", "ddddd ", "<<URL NOTIFY>>").generateHtml();
```