# Faspay SDK




Sdk for developing faspay API the platform that works with this SDK:

  - JAVA SE, EE
  - Android (with include it as library)
  - Flutter (with include it as library)


this sdk contains 2 parts of payment ,debit and credit, debit mostly use POST Rest API with json, all objects are wrapped

# Faspay Debit

to begin, you must extends the class FaspayUserDebit like this:

```groovy
public class TestFaspayUser extends FaspayUserDebit{

    public TestFaspayUser() {
        super("SINTESA", "32254", "bot32254", "p@ssw0rd", "");
    }

}
```

or you can make it with setting all properties, but thats not recommended. 

# Faspay Debit Config


this phase rely on class FaspayConfigDebitDev (if you are still in development phase), FaspayConfigDebitProd (if you are ready to depoly as productions) ,code as follows:
```groovy
TestFaspayUser mTestFaspayUser = new TestFaspayUser();
FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);
```

# Faspay Debit Service Inquiry Payment Channel

this phase are implementation of class FaspayInquiryPCService to declare, write it as follows:

```java
FaspayConfigDebit mFaspayConfig = new FaspayConfigDebitDev(mTestFaspayUser);
FaspayInquiryService service = new FaspayInquiryPCServiceImpl(mFaspayConfig);
```




