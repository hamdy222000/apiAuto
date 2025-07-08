# REST API Test Automation Framework

This project is a simple, scalable, and maintainable REST API test automation framework for testing the [Reqres.in](https://reqres.in/) demo API.  
It is built using Java, RestAssured, and TestNG, following clean code principles and best practices for API testing automation.  
The framework supports parallel test execution, external JSON test data, detailed logging with Log4j2, and comprehensive reporting using Allure.

---

## Features

- Clean service classes to encapsulate API endpoints 
- Separate validation classes for response assertions
- Parallel test execution support with TestNG
- External JSON files for test data management
- Custom reusable utilities for reading files, logging, and reporting
- Log4j2 for advanced logging with per-test log files
- RetryAnalyzer for retrying flaky tests automatically
- Allure report integration with automatic attachment of logs in failure cases
- Maven-based project for easy dependency and lifecycle management
- GitHub Actions integration for automated CI/CD on every push and pull request

---

## Technologies Used

- Java 23
- Maven
- RestAssured 5.5.5
- TestNG 7.9
- Allure Report (v2.24)
- Log4j2 (v2.24.3)
- JsonPath (for JSON handling)
- Commons IO (for file operations)

---

## How to Run the Tests

1. Clone the repository:
```bash
git clone https://github.com/hamdy222000/apiAuto.git
```
2. Import the project as a Maven project into your IDE.

3. Ensure Java 23 and Maven are installed on your system.

4. Run the tests using Maven:
```bash
mvn clean test
```
Or specify a TestNG suite XML file (e.g., regression.xml):
```bash
mvn clean test "-Dsurefire.suiteXmlFiles=regression.xml"
```
5. Generate and view the Allure report:
```bash
allure serve testOut/allure-results
```

---

## Test Coverage

- Login API: valid and invalid scenarios

- Registration API: success and failure cases

- Users API: get list of users, get single user, create, update (PUT/PATCH), and delete operations

- Resource API: get list of resources, get single resource, and handling not found cases

- Response validations include status codes, body content, error messages, and empty responses

---

##  Continuous Integration (CI/CD)

This project uses **GitHub Actions** to run REST API tests automatically on every `push` or `pull request` to the `main` branch.

###  Workflow Features:
- Runs tests using `mvn clean test`
- Uses Java 23 on Ubuntu latest runner
- Uploads **Allure Report results** as build artifacts
- Validates build status before allowing merge (if branch protection is enabled)

###  Workflow Summary:
```yaml
name: Run API Tests with Allure Report
on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]
jobs:
  api-tests:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '23'
      - run: mvn clean test
      - uses: actions/upload-artifact@v4
        with:
          name: allure-results
          path: testOut/allure-results
```

## Author
Mahmoud Hamdy
ISTQB Certified Tester Engineer – CTFL


