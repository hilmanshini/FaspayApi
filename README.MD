# Faspay SDK




Sdk for developing faspay API the platform that works with this SDK:

  - JAVA SE, EE
  - Android (with include it as library)
  - Flutter (with include it as library)


this sdk contains 2 parts of payment ,debit and credit, debit mostly use POST Rest API with json, all objects are wrapped

# Faspay Debit

to begin, you must extends the class FaspayUserDebit like this:

```groovy
public class TestFaspayUserProduction extends FaspayUserDebit{

    public TestFaspayUserProduction() {
        super("SINTESA", "32254", "bot32254", "p@ssw0rd", "");
    }
}
public class TestFaspayUserDevelopment extends FaspayUserDebit{

    public TestFaspayUserProduction() {
        super("SINTESA", "32254", "bot32254", "p@ssw0rd", "");
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




