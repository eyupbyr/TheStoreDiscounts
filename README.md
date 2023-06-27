# TheStoreDiscounts

This project is a Java program that calculates the net payable amount for a given bill on a retail website, taking into account various discounts based on user attributes and bill total.

## Description

On a retail website, the following discounts apply:
1.  If the user has gold card of the store, he gets a 30% discount
2.  If the user has silver card of the store, he gets a 20% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $200 on the bill, there would be a $ 5 discount (e.g. for $ 950, you get $ 20
as a discount).
5. The percentage based discounts do not apply on phones.
6. A user can get only one of the percentage based discounts on a bill.



### Building The Project

To perform a clean build run this command

```bash
mvn clean install
```

### Tests and Code Coverage

To execute the unit tests and generate code coverage report run this command

```bash
mvn clean test jacoco:report
```

To view the generated report run this command

```bash
start target/site/jacoco/index.html
```

### SonarQube Report

To generate SonarQube report make sure SonarQube is installed and running at http://localhost:9000. You will also need to change sonar login credentials in pom.xml file. 

Run this command

```bash
mvn sonar:sonar
```

### Usage

To test with different type of parameters you can modify the values in Main file.