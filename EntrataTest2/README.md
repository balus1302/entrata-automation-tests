## Entrata
The goal of this project is to automate test cases covering several Entrata products and demonstrate how Entrata enhances the efficiency of these products, as explained in the webinar video. The process also includes submitting details through a form to request access to the demo.

## Project Structure
+ **src/main/java**
    + **pojo**
        * Browser.java
    + **pom**
        * LandingPage.java
    + **utility**
        * BaseClass.java


+ **src/test/java**
    + **Test**
        * EntrataTests.java

+ **test-output**
    + **html-reports**

+ **pom.xml**
+ **README.md**
+ **testng.xml**

Above mentioned folders/files except README.md are necessary to run project. With gradual execution of project, Maven shall create folders for storing test execution results.

## Modules Covered
+ **EntrataTests**- How it works, Products, Watch Demo


## Dependencies
To run project, following **dependencies should be installed** in your system.

### Default Java JRE/JDK (11+)
* Download and Install JDK from Oracle's official site:

* Verify the installation with:
```
java -version
```


### Maven 
* Download and Install Maven:

* Verify the installation with:

```
mvn -version
```

* Add Maven to the system PATH environment variable.

### Chrome Browser

* Download and Install Chrome:

* Verify the installation with:

```
chrome --version
```

### ChromeDriver

* Download and Install ChromeDriver:

* Add the chromedriver.exe to your system's PATH environment variable and verify the installation with:

```
chromedriver --version
```

## Third Party Libraries

Following is the list of third party libraries used in this project: These can be found under `dependenices tag`
in `pom.xml`. This can be downloaded from Maven repository.

* [selenium-java]
* [webdrivermanager]
* [TestNG]  - For converting methods to test cases.



## Configurations

* You can include/exclude certain test methods by configuring `testng.xml` :

```
<test thread-count="5" name="{{TEST_NAME}}" verbose="10">
		<classes>
			<class name="{{PACKAGE_NAME.CLASS_NAME}}" >
				<methods>
        			<include name="{{METHOD_NAME}}" />
        			<exclude name="{{METHOD_NAME}}" />
      			</methods>
			</class>
		</classes>
</test>
```

> For more info, please
> refer [Include and Exclude Test Methods in TestNG](https://www.seleniumeasy.com/testng-tutorials/include-exclude-test-methods-in-testng)

## Run project
* Go inside the project:

```
cd C:\path\to\project  
```

* Run Maven build

```
mvn clean test
```

> After run, html reports will get generated.

## Known Issues

* If you get below error:

```
Unexpected error: java.security.InvalidAlgorithmParameterException: the trustAnchors parameter must be non-empty -> [Help 1]
```

Run following commands:

```
rm /etc/ssl/certs/java/cacerts
update-ca-certificates --fresh
```
