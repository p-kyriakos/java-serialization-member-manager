# Java Serialization Member Manager

A simple Java console application for managing members and storing data with object serialization.

The project demonstrates how Java objects can be saved to a `.ser` file and loaded again when the application starts.

## Features

- Add new members
- View all saved members
- Search members by name
- Search members by code
- Edit existing member information
- Delete members by code
- Save and load data using Java serialization

## Project Structure

```text
Java/
  Program/
    Katalogos.java      # Handles serialization and deserialization
    MainProgram.java    # Console menu and application flow
    Member.java         # Member model class
```

## Requirements

- Java Development Kit (JDK) 8 or newer

## How to Run

From the root folder of the project, compile the source files:

```bash
javac -encoding UTF-8 -d out Java/Program/*.java
```

Then run the application:

```bash
java -cp out Program.MainProgram
```

## Data Storage

The application creates a `member.ser` file automatically when member data is saved.

This file is ignored by Git because it contains local runtime data and should not be uploaded to the repository.

## Repository Purpose

This project was created as a small Java practice project focused on:

- Object-oriented programming
- Console-based user interaction
- File handling
- Serialization and deserialization
