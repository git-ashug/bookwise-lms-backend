<p align="center">
    <h1 align="center">bookwise-lms-backend</h1>
</p>
<p align="center">
    <em><code>Backend of Bookwise App</code></em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/last-commit/git-ashug/bookwise-lms-backend?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/git-ashug/bookwise-lms-backend?style=flat&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/git-ashug/bookwise-lms-backend?style=flat&color=0080ff" alt="repo-language-count">
</p>
<p align="center">
		<em>Built with the tools and technologies:</em>
</p>

### Backend

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-BC4521?style=for-the-badge&logo=lombok&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white)

### Integration Services
![Stripe](https://img.shields.io/badge/Stripe-626CD9?style=for-the-badge&logo=stripe&logoColor=white)
![Okta](https://img.shields.io/badge/Okta-007DC1?style=for-the-badge&logo=okta&logoColor=white)

### Development Tools
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
<br>

---

##### 🔗 Table of Contents

- [📍 Overview](#-overview)
- [👾 Features](#-features)
- [📂 Repository Structure](#-repository-structure)
- [🧩 API Endpoints](#-modules)
- [🚀 Getting Started](#-getting-started)
    - [🔖 Prerequisites](#-prerequisites)
    - [📦 Installation](#-installation)
    - [🤖 Usage](#-usage)
    - [🧪 Tests](#-tests)
- [🤝 Contributing](#-contributing)

---

## 📍 Overview

BookWise is a full-featured Library Management System that provides a modern digital solution for libraries to manage their books, user checkouts, reviews, and administrative tasks. The system is built using Spring Boot for the backend and integrates with a React frontend.

---

## 👾 Features

### 1. Book Management
- Browse and search books by title and category
- View book details including availability status
- Admin capabilities:
  - Add new books to the library
  - Update book quantities
  - Remove books from the system
  - Manage book inventory

### 2. User Features
- Checkout books
- Return books
- Renew book loans
- View current loans and loan history
- Check remaining days for borrowed books
- Post book reviews and ratings
- Send messages/queries to administrators

### 3. Review System
- Users can post reviews for books
- Rating system implementation
- Optional review descriptions
- One review per book per user policy

### 4. Payment Integration
- Secure payment processing using Stripe
- PCI complaint

### 5. Security Features
- OAuth 2.0 implementation with Okta
- JWT-based authentication
- Secure endpoints with role-based access
- CORS configuration for frontend integration

### 6. Admin Dashboard
- Manage book inventory
- Handle user queries and messages
- Monitor checkout activities
- Process book returns
- View and manage user reviews

### 7. Message System
- Users can send queries to administrators
- Admin response system
- Message status tracking (open/closed)
- Organized message management

---

## 📂 Repository Structure

```sh
└── bookwise-lms-backend/
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── com
        │   │       └── bookwise
        │   └── resources
        │       └── application.properties
        └── test
            └── java
                └── com
                    └── bookwise
```
## 🧩 API Endpoints
### Book Operations
- `GET /api/books/secure/currentloans/count`
- `GET /api/books/secure/ischeckedout/byuser`
- `PUT /api/books/secure/checkout`
- `GET /api/books/secure/currentloans`
- `PUT /api/books/secure/return`
- `PUT /api/books/secure/renew/loan`
- `POST /api/books/secure/admin/add`

### Review Operations
- `GET /api/reviews/secure/user/book`
- `POST /api/reviews/secure`

### Message Operations
- `POST /api/messages/secure/add/message`
- `PUT /api/messages/secure/admin/message`

### Payment Operations
- `POST /api/payment/secure/payment-intent`
- `PUT /api/payment/secure/payment-complete`

## 🚀 Getting Started

### 🔖 Prerequisites

**Java**: `version 17`

### 📦 Installation

Build the project from source:

1. Clone the bookwise-lms-backend repository:
```sh
❯ git clone https://github.com/git-ashug/bookwise-lms-backend
```

2. Navigate to the project directory:
```sh
❯ cd bookwise-lms-backend
```

3. Install the required dependencies:
```sh
❯ mvn clean install
```

### 🤖 Usage

To run the project, execute the following command:

```sh
❯ java -jar target/myapp.jar
```

### 🧪 Tests

Execute the test suite using the following command:

```sh
❯ mvn test
```

---

## 🤝 Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Report Issues](https://github.com/git-ashug/bookwise-lms-backend/issues)**: Submit bugs found or log feature requests for the `bookwise-lms-backend` project.
- **[Submit Pull Requests](https://github.com/git-ashug/bookwise-lms-backend/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/git-ashug/bookwise-lms-backend/discussions)**: Share your insights, provide feedback, or ask questions.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/git-ashug/bookwise-lms-backend
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/git-ashug/bookwise-lms-backend/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=git-ashug/bookwise-lms-backend">
   </a>
</p>
</details>

---
