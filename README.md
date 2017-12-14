QA Demo
=======

About
-----

This is an example of integrating jUnit, Selenium and Cucumber.
The test suite will query Amazon store for Nikon products, sort the 
results and assert on product description.

Prerequisites
-------------

* JDK 1.8
* maven
* Chrome
* chromedriver.exe

Run tests
---------

The following properties should be defined in config.properties file:
  * webdriver.chrome.driver: the path for the webdriver(e.g. chromedriver.exe for Chrome)
  * sut.url: the URL for the Site Under Test (e.g. https://www.amazon.com)
  * sut.timeout: the timeout allowed for a page (or specific element) to load

The PATH and JAVA_HOME should point to valid locations:
```
set PATH=C:\Java\jdk1.8.0_152\bin;%PATH%
set PATH=C:\Opt\apache-maven-3.5.2\bin;%PATH%
set JAVA_HOME=C:\Java\jdk1.8.0_152
```

Maven can be used for test execution:
```
mvn test
```
