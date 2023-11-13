# Selenium Test Automation Framework

This repository contains a Selenium-based test automation framework using TestNG for web application testing. The
framework is designed to provide a structured and scalable approach to writing and executing automated tests.

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Writing Test Cases](#writing-test-cases)
- [Executing Tests](#executing-tests)
- [Reporting](#reporting)
- [Configuring Tests](#configuring-tests)
- [Contributing](#contributing)
- [License](#license)

## Overview

This test automation framework is built on Selenium WebDriver and utilizes the TestNG testing framework. It follows the
Page Object Model (POM) design pattern, providing a foundation for writing modular, maintainable, and scalable automated
tests for web applications.

## Prerequisites

Ensure you have the following software installed:

- Java Development Kit (JDK)
- Maven
- WebDriver (ChromeDriver, GeckoDriver, etc.)
- Your favorite integrated development environment (IDE)

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/selenium-test-automation.git
   ```

2. Navigate to the project directory:

   ```bash
   cd selenium-test-automation
   ```

3. Install dependencies:

   ```bash
   mvn clean install
   ```

## Project Structure

The project is structured as follows:

- **src/main/java:** Contains utility classes, page objects, and base classes.
- **src/test/java:** Contains test classes.
- **src/test/resources:** Contains configuration files and test data.
- **target:** Contains compiled classes and test reports.

## Configuration

Configure your test environment by updating properties in the `config.properties` file in the `src/test/resources`
directory. Ensure WebDriver executable paths, application URLs, and other settings are correctly specified.

## Writing Test Cases

Write your test cases using the TestNG annotation framework. Test classes are located in the `src/test/java` directory.
Leverage page objects and utility classes from the `src/main/java` directory for a modular and reusable approach.

## Executing Tests

Execute tests using Maven. Run the following command in the project root directory:

```bash
mvn clean test
```

## Reporting

Test reports are generated using the ExtentReports library. Access the HTML reports in the `test-output` directory after
test execution.

- **Extent Report Path:** `test-output/Report/index.html`

## Configuring Tests

- **Local and Cloud Testing:** Test can be run locally or in the cloud using platforms like BrowserStack, Sauce Labs, or
  headless mode.
- **Test Configuration:** Configure test settings in the `src/test/resources/TestRunner.xml` file.
- **Report Configuration:** Customize report settings in the `src/test/resources/report-config.xml`
  and `src/main/java/com/kwi/report` directory.

## Contributing

Feel free to contribute to the improvement of this test automation framework by opening issues or submitting pull
requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to adapt and enhance this README to meet the specific requirements of your Selenium test automation framework.