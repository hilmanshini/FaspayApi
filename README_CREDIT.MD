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