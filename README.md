# Bookstore_Managment_App

# PL:

## Aplikacja wspomagająca zarządzanie sklepem handlującym książkami
 
Celem projektu było utworzenie aplikacji w języku Java wspomagającej zarządzanie sklepem
handlującym książkami, audiobookami i e-bookami. Program miał za zadanie umożliwić
efektywne monitorowanie dostępności towarów, ich kategoryzację oraz proces przyjęcia i
sprzedaży produktów.

Rezultatem prac jest w pełni funkcjonalna aplikacja wyposażona w interfejs konsolowy oraz
graficzny (Swing), która oferuje zaawansowane mechanizmy sortowania i wyszukiwania
produktów.

## Screenshoty z wersji z GUI
<img src="https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/docs/aplikacja_gui.png?raw=true" alt="Screenshot"/>
<img src="https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/docs/filtry.png?raw=true" alt="Screenshot"/>
<img src="https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/docs/sell_single_product.png?raw=true" alt="Screenshot"/>

Użytkownik w prosty i wygodny sposób może dokonywać operacji na sklepie za pomocą klikania we właściwe przyciski. Kliknięcie przycisku
wykonuje odpowiednią operacje lub wywołuje odpowiednie okno z dodatkowymi opcjami. Wprowadzanie danych do programu, zrealizowane
jest za pomocą okien dialogowych (popupów), w których użytkownik wprowadza odpowiednie wartości lub klika odpowiednią opcję w celu
wykonania zadania. <br>

Aplikacja umożliwia wygodne i bezpieczne zarządzanie sklepem z książkami. Ze względu na prosty interfejs graficzny, pracownik sklepu nie jest
rozpraszany nadmiarem opcji i w bardzo krótkim czasie może przyswoić obsługę programu.

## Screenshot z wersji konsolowej
<img src="https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/docs/aplikacja_konsolowa.png?raw=true" alt="Screenshot"/>

Pod tabelą wyświetlany jest aktualny stan gotówki. Wszelkie opcje, z których można skorzystać, wymieniono w postaci numerów wraz z
opisami. Opcje zostały oddzielone znakiem `|` imitując wygląd przycisku. Na samym dole użytkownik jest proszony o wprowadzenie
odpowiedniej wartości liczbowej, oznaczającej właściwą opcję. W przypadku wprowadzenia niewłaściwego numeru opcji, aplikacja wyświetla
odpowiedni komunikat informujący o wprowadzeniu nieznanej wartości i prosi użytkownika o wprowadzenie poprawnej liczby.<br>

Aplikacja działa w taki sposób, że po wprowadzeniu wszystkich wymaganych wartości przez użytkownika, wykonuje operacje na sklepie po
czym odświeża całkowity pogląd na magazyn i stan gotówki.

## Sortowanie listy obiektów

W metodzie `sortByT()` zastosowałem sprytne rozwiązanie problemu sortowania listy zawierającej różne typy obiektów dziedziczących po `CLiterature`.

**Problem:** Lista `warehouse` może zawierać różne podtypy `CLiterature`, z których tylko niektóre mają pola potrzebne do sortowania.

**Rozwiązanie:**
1. Wyfiltrowanie z listy tylko obiektów konkretnego typu `T` (które na pewno mają wymagane pola)
2. Posortowanie tej przefiltrowanej listy według zadanego komparatora
3. Zbudowanie wynikowej listy: najpierw posortowane obiekty typu `T`, potem wszystkie pozostałe obiekty w oryginalnej kolejności

Dzięki temu uniknąłem błędów związanych z próbą sortowania obiektów, które nie mają odpowiednich pól, a jednocześnie zachowałem wszystkie elementy z oryginalnej listy.

[Kod](https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/source_code/Bookstore_final/Shop/src/warehouse/CWarehouse.java)<br>

# EN:

## An application supporting the management of a bookstore
 
The aim of the project was to create a Java application to support the management of a store selling books, 
audiobooks, and e-books. The program was designed to enable effective monitoring of product availability, categorization, 
and the process of receiving and selling products.

The result of this work is a fully functional application equipped with a console and graphical interface (Swing), which 
offers advanced product sorting and search mechanisms.

## Screenshots from the GUI version
<img src="https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/docs/aplikacja_gui.png?raw=true" alt="Screenshot"/>
<img src="https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/docs/filtry.png?raw=true" alt="Screenshot"/>
<img src="https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/docs/sell_single_product.png?raw=true" alt="Screenshot"/>

The user can easily and conveniently perform operations in the store by clicking the appropriate buttons. Clicking a button performs 
the appropriate operation or opens a window with additional options. Data is entered into the program using dialog boxes (pop-ups), in which 
the user enters the appropriate values or clicks the appropriate option to perform the task. <br>

The application enables convenient and secure management of a bookstore. Thanks to its simple graphical interface, store employees are not distracted
by an excess of options and can quickly learn how to use the program.

## Screenshot from the console version
<img src="https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/docs/aplikacja_konsolowa.png?raw=true" alt="Screenshot"/>

The current cash balance is displayed below the table. All available options are listed as numbers with descriptions. The options are separated 
by the `|` character to imitate the appearance of a button. At the very bottom, the user is asked to enter the appropriate numerical value corresponding 
to the desired option. If an incorrect option number is entered, the application displays a message informing the user that an unknown value has been 
entered and asks the user to enter the correct number. <br>

The application works in such a way that after the user enters all the required values, it performs operations on the store and then refreshes the 
overall view of the warehouse and cash balance.

## Sorting the list of objects

In the `sortByT()` method, I used a clever solution to the problem of sorting a list containing different types of objects inheriting from `CLiterature`.

**Problem:** The `warehouse` list may contain different subtypes of `CLiterature`, only some of which have the fields needed for sorting.

**Solution:**
1. Filter only objects of a specific type `T` (which definitely have the required fields) from the list.
2. Sort this filtered list according to the specified comparator.
3. Build the resulting list: first the sorted objects of type `T`, then all other objects in their original order.

This allowed me to avoid errors associated with attempting to sort objects that do not have the appropriate fields, while retaining all items from the original list.

[Code](https://github.com/A-t-l-as/Bookstore_Managment_App/blob/main/source_code/Bookstore_final/Shop/src/warehouse/CWarehouse.java)<br>