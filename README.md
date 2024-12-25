
# Banking System

A **Banking System** application implemented in Java with JDBC to demonstrate core banking functionalities such as account management, transactions, and data persistence in a relational database. 🌟🌟🌟

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Banking System project is designed to simulate basic banking operations. It uses **Java** as the programming language and **JDBC** for database interactions. This application provides a command-line interface to interact with the system and perform tasks like creating accounts, depositing, withdrawing money, and checking balances. 🌟🌟🌟

## Features

- Create and manage bank accounts.
- Perform deposits and withdrawals.
- Check account balances.
- Maintain a transaction log.
- Persistent data storage using a relational database.

## Technologies Used

- **Java**: Core programming language.
- **JDBC**: For database connectivity.
- **MySQL**: Relational database for storing account and transaction data.

## Installation

Follow these steps to set up and run the project: 🌟🌟🌟

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/AyushPrakash414/Banking-System.git
   cd Banking-System
   ```

2. **Set Up the Database**:
   - Install MySQL and create a database for the project.
   - Import the provided SQL script (e.g., `schema.sql`) to set up the required tables.

3. **Configure Database Connection**:
   - Update the database credentials in the `DatabaseConnection` class or the relevant configuration file.
   - Example:
     ```java
     String url = "jdbc:mysql://localhost:3306/banking_system";
     String username = "your_username";
     String password = "your_password";
     ```

4. **Compile and Run**:
   - Compile the Java files:
     ```bash
     javac *.java
     ```
   - Run the application:
     ```bash
     java Main
     ```

## Usage

The application is command-line based. 🌟🌟🌟

- Follow the on-screen instructions to navigate through the options.
- Example operations:
  1. Create a new account.
  2. Deposit or withdraw money.
  3. Check balance.

## Project Structure

```
Banking-System/
├── src/
│   ├── Main.java            # Entry point of the application
│   ├── Account.java         # Account-related operations
│   ├── Transaction.java     # Transaction logic
│   ├── DatabaseConnection.java  # Handles database connectivity
│   └── ... (other files)
├── database/
│   ├── schema.sql           # SQL script for database setup
├── README.md                # Project documentation
```

## Contributing

Contributions are welcome! To contribute: 🌟🌟🌟

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add feature-name"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-name
   ```
5. Open a pull request.

## License

This project is licensed under the [MIT License](LICENSE). 🌟🌟🌟

---
