# Java Swing Diary Application Plan

## Goal
Create a simple, aesthetically pleasing Java Swing diary application with MySQL database integration. The application will allow users to create, save, load, search, and delete diary entries.

## Architecture & File Structure

The application will be structured for high cohesion, separating concerns into distinct components to promote maintainability and simplicity.

-   **`main/DiaryApp.java`**: The main entry point of the application. This class will be responsible for initializing and displaying the main UI.
-   **`ui/DiaryUI.java`**: This class will manage all Java Swing components, layout, and user interface logic. It will handle user input and display diary data.
-   **`dto/DiaryEntry.java`**: A Data Transfer Object (DTO) class to represent a single diary entry. It will encapsulate the data for a diary entry (e.g., ID, title, content, timestamp).
-   **`db/DiaryDAO.java`**: This class will handle all interactions with the MySQL database, including connecting, saving, loading, deleting, and searching diary entries. It will abstract the database logic from the rest of the application.
-   **`resources/` (or similar):** A directory to store assets like images and potentially configuration files.

## UI Design (`ui/DiaryUI.java`)

The UI will be built using Java Swing components, focusing on simplicity and visual appeal.

### Components:
-   **Input Fields:** `JTextField` for the diary entry title and `JTextArea` for the content. A date input mechanism will be considered, possibly using `JTextField` with validation or a `JDatePicker` component if readily available and simple to integrate.
-   **Buttons:** `JButton` for actions like "Save", "Load", "Delete", "Search".
-   **Display Area:** A `JTextArea` or `JList` to display loaded diary entries or search results.
-   **Aesthetics:**
    -   **Color Palette:** Use a pleasant, calming color scheme (e.g., pastel tones, soft blues, greens, or grays).
    -   **Image:** Include a decorative image, possibly related to diaries or journaling. A placeholder `diary_visual.png` will be used.

### Layout:
-   The main `JFrame` will use `BorderLayout`.
-   A `JPanel` for input fields will be in `NORTH`.
-   A `JPanel` for buttons will be in `CENTER` or `SOUTH`.
-   A `JPanel` for displaying entries will be in `CENTER` or `SOUTH`.
-   A dedicated panel for an image will be integrated, perhaps in the `SOUTH` of the main panel or within the `centerPanel` as requested previously.

## DTO (`dto/DiaryEntry.java`)

A simple Java class to hold diary entry data.

### Fields:
-   `id` (int): Unique identifier for the diary entry (primary key).
-   `title` (String): The title of the diary entry.
-   `content` (String): The main body of the diary entry.
-   `timestamp` (java.sql.Timestamp): The date and time the entry was created or last modified.

### Methods:
-   Constructor(s).
-   Getters and setters for all fields.

## Database Interaction (`db/DiaryDAO.java`)

Handles all database operations using MySQL.

### Database Schema:
A `diary_entries` table will be used.

```sql
CREATE TABLE diary_entries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Methods:
-   `connect()`: Establishes and returns a `Connection` to the MySQL database. Requires database URL, username, and password (to be configured or provided).
-   `disconnect(Connection conn, Statement stmt, ResultSet rs)`: Closes database resources.
-   `saveEntry(DiaryEntry entry)`: Inserts a new diary entry into the database.
-   `loadEntries()`: Retrieves all diary entries from the database and returns them as a `List<DiaryEntry>`.
-   `deleteEntry(int id)`: Deletes a diary entry by its ID.
-   `searchEntries(String query)`: Searches for diary entries based on title or content keywords. Returns a `List<DiaryEntry>`.

## Simplicity and Aesthetics

-   **Simplicity:** Code will be kept straightforward, using standard Java and Swing features. Complex patterns will be avoided unless necessary for clarity and the requested modularity.
-   **Aesthetics:** A visually appealing color scheme will be chosen. A decorative image will be integrated into the UI, likely in the `SOUTH` or `CENTER` area.

## Next Steps (Assumed)
Upon user confirmation or further directives, the following will be implemented:
1.  Create the `DiaryEntry.java` DTO.
2.  Implement the `DiaryDAO.java` class with database connection and CRUD operations.
3.  Develop the `DiaryUI.java` with Swing components and layout.
4.  Create the `DiaryApp.java` to launch the application.
5.  Add specified colors and image.

This plan provides a solid foundation for building the diary application according to the user's requirements.
