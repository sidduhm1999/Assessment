# Selenium Automation Project - QKart Login Tests

This project is a **Selenium WebDriver automation framework** built using **Java**, **Gradle**, and **TestNG**. It automates the login functionality for the QKart application, including validation of successful login, logout, and invalid credentials handling.

---

## Table of Contents

* [Project Overview](#project-overview)
* [Technologies Used](#technologies-used)
* [Project Structure](#project-structure)
* [Setup Instructions](#setup-instructions)
* [Test Scenarios](#test-scenarios)
* [Running Tests](#running-tests)
* [Important Notes](#important-notes)

---

## Project Overview

This project demonstrates:

* Launching a web browser and navigating to QKart login page.
* Performing **valid login** and verifying dashboard access.
* Performing **invalid login** and verifying appropriate error messages.
* Logging out successfully after a valid login.
* Using **Page Object Model (POM)** design pattern.
* Using **Gradle** as a build automation tool.
* Reading test configurations from `config.properties`.

---

## Technologies Used

* **Java** (latest stable version)
* **Selenium WebDriver**
* **TestNG**
* **Gradle**
* **Apache Commons IO** (for file handling if screenshots needed)
* **ChromeDriver** (can be updated for other browsers)

---

## Project Structure

```
Assessment/
│
├── app/
│   ├── src/main/java/utilities/
│   │   ├── DriverFactory.java        # WebDriver setup and management
│   │   └── TestUtilities.java       # Helper methods
│   │
│   ├── src/main/java/assessment/
│   │   └── LoginPage.java           # Page object class for login page
│   │
│   └── src/test/java/assessment/
│       └── LoginTests.java          # TestNG test cases
│
├── build.gradle                     # Gradle build file
├── settings.gradle                  # Gradle settings
├── gradlew / gradlew.bat            # Gradle wrapper
├── gradle/                           # Gradle wrapper files
└── src/test/resources/config.properties  # Configuration for tests (browser, URL, credentials)
```

---

## Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/Assessment.git
   cd Assessment
   ```

2. **Install JDK and set JAVA_HOME**
   Ensure Java is installed and the `JAVA_HOME` environment variable points to your JDK installation.

3. **Install ChromeDriver**
   Make sure the ChromeDriver executable is available and matches your Chrome browser version.

4. **Update `config.properties`**

   ```properties
   browser=chrome
   url=https://example.com/login
   Valid.username=your_valid_username
   Valid.password=your_valid_password
   Invalid.username=invalid_user
   Invalid.password=invalid_pass
   ```

---

## Test Scenarios

1. **Valid Login Test**

   * Enter valid username and password.
   * Verify dashboard page loads.
   * Click logout.
   * Expected output: "Logged in successfully" printed to console.

2. **Invalid Login Test**

   * Enter invalid username or password.
   * Verify error message "Invalid credentials" appears.
   * Test passes if login is blocked.

---

## Running Tests

1. **Run tests using Gradle:**

   ```bash
   ./gradlew clean test --no-configuration-cache
   ```

2. **View Test Reports**
   After execution, HTML reports are generated at:

   ```
   build/reports/tests/test/index.html
   ```

3. **Console Output**
   During execution, you will see messages in the terminal such as:

   ```
   Logged in successfully
   Logged out successfully
   ```

---

## Important Notes

* The project uses **Page Object Model (POM)** for better maintainability.
* **Explicit waits** (`WebDriverWait`) are used to handle dynamic elements.
* Thread.sleep is used minimally; in production, use proper waits instead.
* Ensure ChromeDriver matches your browser version.
* The `DriverFactory` class manages WebDriver lifecycle.

---

## Author

**Siddu HM**
Technical Support & QA Automation Enthusiast
