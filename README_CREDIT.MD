# Faspay SDK




Sdk for developing faspay API the platform that works with this SDK:

  - JAVA SE, EE
  - Android (with include it as library)
  - Flutter (with include it as library)


this sdk contains 2 parts of payment ,debit and credit, debit mostly use POST Rest API with json, all objects are wrapped
for faspay credit - __[click here ](https://github.com/hilmanshini/FaspayApi/blob/master/README_CREDIT.MD)__ - 


for faspay debit you can follow docs below 
# Faspay Debit

to begin, you must extends the class FaspayUserDebit like this:

```groovy
public class TestFaspayUserProduction extends FaspayUserDebit{

    public TestFaspayUserProduction() {
        super(bla bla bla);
    }
}
public class TestFaspayUserDevelopment extends FaspayUserDebit{

    public TestFaspayUserProduction() {
        super(bla bla bla);
    }
}
```

or you can make it with setting all properties, but thats not recommended. 

# Faspay Debit Config


this phase rely on class FaspayConfigDebitDev (if you are still in development phase), FaspayConfigDebitProd (if you are ready to depoly as productions) , base class is FaspayConfigDebit, so you should use FaspayConfigDebit as declare class on instance, code as follows:
```groovy
// if you ready to submit to production
TestFaspayUser mTestFaspayUser = new TestFaspayUserProduction();
FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitProd(mTestFaspayUser);


//if you are still in development phase
TestFaspayUser mTestFaspayUser = new TestFaspayUserDevelopment();
FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);


```

# Faspay Debit Service Inquiry Payment Channel
this function is needed to get payment channel based on your purcahse
this phase are implementation of class FaspayInquiryPCService to declare, write it as follows:

```java
FaspayInquiryService service = new FaspayInquiryPCServiceImpl(mFaspayConfig);
service.inquiryPaymentChannel(new FaspayInquiryPCService.FaspayInquiryServiceCallback() {
            @Override
            public void onGetPaymentChannel(List<FaspayPaymentChannel> channel) {
                for (FaspayPaymentChannel faspayPaymentChannel : channel) {
                    System.out.println(faspayPaymentChannel.getPg_code() + " " + faspayPaymentChannel.getPg_name());

                }

            }

            @Override
            public void onErrorGetPaymentChannel(Exception e) {
                e.printStackTrace();

            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                System.out.println(mUnregisteredError.getResponse_error().getResponse_code());

            }
        });
```




# Faspay Debit Create Payment
this function is needed for you to create payment 

```java
    //from previous code
    TestFaspayUser mTestFaspayUser = new TestFaspayUser();
    FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);

    //from inquiry payment channel,or mock it
    FaspayPaymentChannel mFaspayPaymentChannel = new FaspayPaymentChannel();
    mFaspayPaymentChannel.setPg_code("402");
    mFaspayPaymentChannel.setPg_name("ALFA");


    //list all your items
    List<FaspayPayment> item = new ArrayList<>();
    // (#Item name, #amount ,#price, #paymentType, #merchantId , #tenorType)
    item.add(new FaspayPayment("Item Name", 1, 100000, FaspayPayment.PAYMENT_PLAN_FULL_SETTLEMENT, mFaspayConfig.getFaspayUser().getMerchantId(), FaspayPayment.TENOR_FULL));

    //create bill data
    // (String billNo,String billDesc, int expired_day_interval, String billTotal,List<FaspayPayment> item) 
    FaspayPaymentRequestBillData billing = new FaspayPaymentRequestBillData("123123", "x", 10, "10000", item);

    //create bill user data
    //(String phoneNumber, String email, String terminal, String custNo, String custName)
    FaspayPaymentRequestUserData mFaspayPaymentRequestUserData = new FaspayPaymentRequestUserData("087123123123", "hil@hil.com", String.valueOf(FaspayPaymentRequestWrapper.TERMINAL_MOBILE_APP_ANDROID), "123123", "hahahaha");


    //create shipping data
    FaspayPaymentRequestShippingData mFaspayPaymentRequestShippingData = new FaspayPaymentRequestShippingData();

    //wrap it up
    FaspayPaymentRequestWrapper mFaspayPaymentRequestWrapper = new FaspayPaymentRequestWrapper(mFaspayConfig, billing, mFaspayPaymentChannel, mFaspayPaymentRequestUserData, mFaspayPaymentRequestShippingData);


    //send to server
    FaspayPaymentService mFaspayPaymentService = new FaspayPaymentServiceImpl(mFaspayConfig);
        mFaspayPaymentService.createBilling(mFaspayPaymentRequestWrapper, new FaspayPaymentService.FaspayCreateBillingServiceCallback() {
            @Override
            public void onGetPaymentResponse(FaspayPaymentResponse channel) {
                System.out.println("OK");

                inquiry(channel, mFaspayPaymentService, mFaspayConfig);
            }

            @Override
            public void onErrorGetPaymentResponse(Exception e) {
                System.out.println("ERRO");
                e.printStackTrace();
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                System.out.println("unreg " + mUnregisteredError.getResponse_error().getResponse_desc());
            }

        });
```

# IMPORTANT! Faspay Payment Notification
when users accept payment or cancel payment the notification of payment status are sent to your server , Contact faspay support to register your callback url notification, 

your callback controller from your http server  must response the request from faspay in the format that suits faspay needs , 
the format could be generated with this code in your controller
```java
FaspayXMLResponse e = new XmlMapper().readValue((raw), FaspayXMLResponse.class);
// here your can get property from FaspayXMLResponse to be handled 
new XmlMapper().writeValue(res, new FaspayTraceSuccessXMLResponse(e));
```

# Faspay Debit Cancel Payment
this function is needed for you to cancel payment 

```java
    //create inline Wrapper (String trxId,  String billNo, String paymentCancel,FaspayConfigDebit mFaspayConfig)
    //and send it
    mFaspayPaymentService.cancelTransaction(new FaspayCancelPaymentRequestWrapper( channel.getTrxId(), channel.getBillNo(), "test", conf), new FaspayPaymentService.FaspayCancelPaymentCallback() {
            @Override
            public void onCancelPaymentSuccess(FaspayCancelPaymentResponse channel) {
                System.out.println("CANCELED " + channel.getPaymentStatusDesc());
                latch.countDown();
            }

            @Override
            public void onErrorRequstCancelPayment(Exception e) {
                e.printStackTrace();
                System.out.println("error ");
                latch.countDown();
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                System.out.println("UNREG");
                latch.countDown();
            }
        });
```



# Faspay Debit inquiry Payment
this function is needed for you to inquirt payment 

```java
    //and send it
    mFaspayPaymentService.inqueryPaymentStatus(new FaspayPaymentStatusRequestWrapper("", channel.getTrxId(), channel.getBillNo(), conf), new FaspayPaymentService.FaspayInquiryPaymentStatusCallback() {
            @Override
            public void onGetInquiryPaymentStatusResponse(FaspayPaymentStatusResponse channel) {
                System.out.println("OK "+channel.getPaymentStatusDesc());
                latch.countDown();
                
            }

            @Override
            public void onErrorGetInquiryPaymentStatusResponse(Exception e) {
                e.printStackTrace();
                System.out.println("ERROR ");
                latch.countDown();
            }

            @Override
            public void onUserNotRegistered(UnregisteredError mUnregisteredError) {
                System.out.println("UNREG");
                latch.countDown();
            }
        });
```





