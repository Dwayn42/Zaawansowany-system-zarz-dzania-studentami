# Zaawansowany System Zarządzania Studentami

## Opis projektu
Zaawansowany system zarządzania studentami (SMS) w języku Java. System umożliwia zarządzanie danymi studentów za pomocą graficznego interfejsu użytkownika (GUI), a dane są przechowywane w bazie danych SQLite. Użytkownik może dodawać, usuwać, aktualizować i wyświetlać dane studentów, a także obliczać średnią ocen wszystkich studentów.

---

## Funkcjonalności
- **Dodawanie studenta**: Dodanie nowego studenta do bazy danych.
- **Usuwanie studenta**: Usunięcie studenta za pomocą jego ID.
- **Aktualizacja studenta**: Aktualizacja danych istniejącego studenta.
- **Wyświetlanie studentów**: Pobieranie i wyświetlanie wszystkich rekordów studentów.
- **Obliczanie średniej ocen**: Obliczenie średniej ocen wszystkich studentów.

---

## Instrukcja uruchomienia
### Wymagania systemowe
- Java 8 lub nowsza.
- SQLite JDBC Driver (sqlite-jdbc-3.47.2.0.jar).

### Kroki uruchomienia
1. Pobierz pliki projektu.
2. Upewnij się, że plik bazy danych `students.db` znajduje się w katalogu głównym projektu.
3. W terminalu skompiluj wszystkie pliki źródłowe:
   ```
   javac -cp .;sqlite-jdbc-3.47.2.0.jar *.java
   ```
4. Uruchom aplikację:
   ```
   java -cp .;sqlite-jdbc-3.47.2.0.jar StudentManagerGUI
   ```

---

## Struktura projektu
- **Student.java**: Klasa reprezentująca obiekt studenta.
- **StudentManager.java**: Interfejs definiujący operacje na danych studentów.
- **StudentManagerImpl.java**: Implementacja interfejsu `StudentManager`, obsługująca operacje CRUD w bazie SQLite.
- **StudentManagerGUI.java**: Klasa odpowiedzialna za graficzny interfejs użytkownika.
- **students.db**: Plik bazy danych SQLite przechowujący dane studentów.
- **sqlite-jdbc-3.47.2.0.jar**: Biblioteka JDBC umożliwiająca połączenie z bazą SQLite.

---

## Konfiguracja bazy danych
Aby utworzyć tabelę `students`, wykonaj następujące zapytanie SQL:
```sql
CREATE TABLE students (
    studentID TEXT PRIMARY KEY,
    name TEXT NOT NULL,
    semestr TEXT NOT NULL,
    grade REAL NOT NULL,
    student_group TEXT NOT NULL,
    age TEXT NOT NULL
);
```

---

## Przykłady użycia
### Dodanie nowego studenta:
1. Wprowadź dane studenta w polach:
   - ID studenta,
   - Imię,
   - Semestr,
   - Ocena,
   - Grupa,
   - Wiek.
2. Kliknij **"Dodaj"**.
3. Komunikat w panelu wyświetli potwierdzenie dodania studenta.

### Wyświetlanie studentów:
1. Kliknij **"Wyświetl Studentów"**.
2. Lista studentów zostanie wyświetlona w panelu.

---

## Uwagi końcowe
- Upewnij się, że plik bazy danych `students.db` znajduje się w katalogu głównym projektu.
- W przypadku problemów z bazą danych, upewnij się, że tabela `students` istnieje i jej struktura jest zgodna z powyższym zapytaniem SQL.
- Dziękujemy za skorzystanie z naszego systemu! 😊