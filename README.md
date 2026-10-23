# Digital Legacy Vault with a Dead-Man’s Switch

## Project Overview

The **Digital Legacy Vault with a Dead-Man’s Switch** is a web-based application developed using Java and Spring Boot. It helps users manage their digital legacy information, maintain trusted contacts, and monitor periodic check-ins.

The system tracks whether a user checks in within a configured time period. If the user misses the deadline, the current demo logs a reminder event.

## Features

- User registration and login
- User-specific digital vault management
- Trusted contact management
- Dead-Man’s Switch check-in mechanism
- Check-in deadline monitoring
- Dashboard to view vault and check-in status
- MySQL database integration

## Technologies Used

- **Backend:** Java, Spring Boot
- **Frontend:** HTML, CSS, Thymeleaf, JavaScript
- **Database:** MySQL
- **Build Tool:** Maven
- **Version Control:** Git and GitHub

## Application Modules

1. **Authentication:** Allows users to register and sign in.
2. **Dashboard:** Displays an overview of the user's vault and check-in status.
3. **Digital Vault:** Provides functionality to manage digital vault items.
4. **Trusted Contacts:** Allows users to manage trusted contacts.
5. **Dead-Man’s Switch:** Tracks check-ins and monitors overdue deadlines.
6. **Settings:** Displays switch configuration and related information.

## How It Works

1. A user registers and signs in.
2. The user manages digital vault items and trusted contacts.
3. The system tracks the user's check-in deadline.
4. The user can check in to reset the timer.
5. If the deadline passes, the demo scheduler logs an overdue reminder event.

**Note:** The current educational prototype does not send emails or automatically release vault information.

## Prerequisites

Install the following before running the project:

- Java 17 or later
- MySQL Server 8.0 or compatible
- Git

## Setup and Installation

### 1. Clone the repository

```bash
git clone https://github.com/Goutamchand1507/digital-legacy-vault.git
cd digital-legacy-vault
```

### 2. Create the database

Open MySQL and execute:

```sql
CREATE DATABASE digital_legacy_vault;
```

### 3. Configure database credentials

Configure your database connection using environment variables. Do not commit real passwords or credentials to GitHub.

For PowerShell, set the variables in your terminal:

```powershell
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "your_mysql_password"
```

Replace the example password with your own local MySQL password.

### 4. Run the application

On Windows, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

### 5. Open the application

Visit:

http://localhost:8080/login

## Future Enhancements

- Email notifications and reminders
- Stronger encryption for sensitive vault data
- Additional account security features
- Trusted contact verification
- Secure, user-authorized digital legacy release workflows

## Security Notice

This project is an educational prototype. Do not store real passwords, confidential documents, or sensitive personal information in the demo. Production deployment would require additional security controls and testing.

## Author

**Goutam Chand Honnamude**

GitHub: [Goutamchand1507](https://github.com/Goutamchand1507)

## License

This project is developed for academic and educational purposes.
