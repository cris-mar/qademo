QA Demo
=======

About
-----

This is a proof of concept for integrating jUnit, Selenium and Cucumber.
The test suite will query Amazon webstore for Nikon products, sort the 
results and assert on product description.

Prerequisites
-------------

* JDK 1.8
* maven
* Chrome
* chromedriver.exe

Run tests
---------

The property _webdriver.chrome.driver_ (defined in config.properties file) should 
point to a valid installation of chromedriver.exe. The PATH and JAVA_HOME 
should point to valid locations:

```
set PATH=C:\Java\jdk1.8.0_152\bin;%PATH%
set PATH=C:\Opt\apache-maven-3.5.2\bin;%PATH%
set JAVA_HOME=C:\Java\jdk1.8.0_152
```

Maven can be used for test execution:
```
mvn test
```

