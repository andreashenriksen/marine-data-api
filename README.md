# Marine Data RESTful API

## Overview

The Marine Data RESTful API is a web service designed for the management and retrieval of marine data related to 
locations and temperatures. 
It supports basic CRUD operations (Create, Read, Update, Delete) for marine data entities.
I made this project as a way to learn more about how RESTful APIs work 
and how containerization with docker works as well.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
    - [Endpoints](#endpoints)
    - [Examples](#examples)
- [Author](#author)

## Features

- Retrieve a list of all marine data entries.
- Retrieve details of a specific marine data entry.
- Add new marine data entries.
- Update existing marine data entries.
- Delete marine data entries.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK)
- Maven
- Docker (optional, for containerization)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/marine-data-api.git
   cd marine-data-api
   ```
   
2. Build the project:

   ```bash
   mvn clean install
   ```
   
3. Run the application

   ```bash
   java -jar target/marine-data-api-1.0.jar
   ```
   
## Usage
### Endpoints
- **GET /marine-data:** Retrieve a list of all marine data entries.
- **GET /marine-data/{id}:** Retrieve details of a specific marine data entry.
- **POST /marine-data:** Add a new marine data entry.
- **PUT /marine-data/{id}:** Update an existing marine data entry.
- **DELETE /marine-data/{id}:** Delete a marine data entry.

### Examples
Retrieve all marine data
```bash
curl http://localhost:8080/marine-data
```

Retrieve marine data by ID
```bash
curl http://localhost:8080/marine-data/1
```

Add new marine data
```bash
curl -X POST -H "Content-Type: application/json" -d "{\"location\": \"New Location\", \"temperature\": \"30.0\"}" http://localhost:8080/marine-data
```

Update marine data
```bash
curl -X PUT -H "Content-Type: application/json" -d "{\"location\": \"Updated Location\", \"temperature\": \"25.0\"}" http://localhost:8080/marine-data/1
```

Delete marine data
```bash
curl -X DELETE http://localhost:8080/marine-data/1
```

## Author
Andreas S. Henriksen - [andreashenriksen](https://github.com/andreashenriksen)