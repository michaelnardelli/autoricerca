# AutoSearch Project Documentation

The AutoSearch project is a Java-based application aimed at automating search tasks with additional functionalities for filtering and data reading. This document outlines the structure and usage of the project, which is composed of four main classes: `Ricerca`, `Filtro`, `LetturaDati`, and `Main`.

## Usage

To use the AutoSearch project, compile and run the `Main` class. Ensure that all necessary data inputs are correctly configured in the `LetturaDati` class. Customize the `Filtro` class as needed to apply specific filtering criteria to your search results.

## Requirements

- Java Development Kit (JDK) version 8 or higher.
- Basic understanding of Java programming and the project's structure for customization.

1. Open your terminal or command prompt.
2. Navigate to the directory where your project files are located.
3. Compile the project using the Java compiler (`javac`). If all your Java files are in the same directory, you can compile them with the command:

   ```shell
   javac *.java

## Requirements

- Java Development Kit (JDK) version 8 or higher.
- Basic understanding of Java programming and the project's structure for customization.

## Project Structure

### `Ricerca` Class

The `Ricerca` class is responsible for executing the automated search. It utilizes Java's `Robot` class to simulate mouse and keyboard actions, allowing it to navigate and interact with the user interface programmatically.

#### Key Methods

- `eseguiRicerca`: Executes the search based on specified parameters, such as mouse position and search text.

### `Filtro` Class

The `Filtro` class provides functionality to filter search results. It can be customized to filter out unwanted data based on predefined criteria, ensuring that the search results meet specific requirements.

#### Key Methods

- `applicaFiltro`: Applies filtering criteria to the search results.

### `LetturaDati` Class

The `LetturaDati` class is designed to read and parse data from various sources. It can read data from files, databases, or other input methods and convert it into a format that the `Ricerca` class can use for executing searches.

#### Key Methods

- `leggiDati`: Reads data from the specified source and returns it in a usable format.

### `Main` Class

The `Main` class serves as the entry point of the application. It initializes the necessary components and starts the search process by invoking methods from the other classes.

#### Key Methods

- `main`: The main method that starts the application.

## Usage

To use the AutoSearch project, compile and run the `Main` class. Ensure that all necessary data inputs are correctly configured in the `LetturaDati` class. Customize the `Filtro` class as needed to apply specific filtering criteria to your search results.
if (parts.length == 2) { // Ensure there's a key and a value
key = parts[0].trim();
value = parts[1].trim();
} else {
     blockMap.put(key, value); // Store in HashMap
 }
