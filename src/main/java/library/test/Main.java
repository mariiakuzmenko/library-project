package library.test;

import library.entities.*;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // Створюємо Об'єкт 1: роль Читача
        Roles roleClient = new Roles();
        roleClient.setId(1L);
        roleClient.setRoleName("ROLE_CLIENT");

        // Створюємо Об'єкт 2: роль Бібліотекаря
        Roles roleLibrarian = new Roles();
        roleLibrarian.setId(2L);
        roleLibrarian.setRoleName("ROLE_LIBRARIAN");

        System.out.println("Створено об'єкт: " + roleClient);
        System.out.println("Створено об'єкт: " + roleLibrarian);

        // Створюємо Об'єкт 3: Користувач-Читач (Users)
        Users userReader = new Users();
        userReader.setId(1L);
        userReader.setUsername("taras_she");
        userReader.setPassword("pass123");
        userReader.setFirstName("Тарас");
        userReader.setLastName("Шевченко");
        userReader.setEmail("taras@kobzar.ua");
        userReader.setActive(true);
        userReader.setCreatedDate(new Date());

        // Створюємо Об'єкт 4: Користувач-Бібліотекар (Users)
        Users userLibrarian = new Users();
        userLibrarian.setId(2L);
        userLibrarian.setUsername("ivan_fran");
        userLibrarian.setPassword("pass456");
        userLibrarian.setFirstName("Іван");
        userLibrarian.setLastName("Франко");
        userLibrarian.setEmail("ivan@kamenyar.ua");
        userLibrarian.setActive(true);
        userLibrarian.setCreatedDate(new Date());

        // Додаємо роль читачу
        userReader.getRoles().add(roleClient);
        roleClient.getUsers().add(userReader);

        // Додаємо роль бібліотекарю
        userLibrarian.getRoles().add(roleLibrarian);
        roleLibrarian.getUsers().add(userLibrarian);

        System.out.println("Створено Користувача: " + userReader.getUsername());
        System.out.println("Його роль: " + userReader.getRoles().iterator().next().getRoleName());
        System.out.println("Створено Користувача: " + userLibrarian.getUsername());
        System.out.println("Його роль: " + userLibrarian.getRoles().iterator().next().getRoleName());

        // Створюємо Об'єкт 5: профіль Читача (Readers)
        Readers readerProfile = new Readers();
        readerProfile.setId(1L);
        readerProfile.setLibraryCardNumber("KB-1814");
        readerProfile.setOpenedDate(new Date());

        // Встановлюємо зв'язок: цей профіль належить цьому користувачу
        readerProfile.setUser(userReader);

        System.out.println("Створено профіль читача (картка): " + readerProfile.getLibraryCardNumber());
        System.out.println("Власник профілю: " + readerProfile.getUser().getLastName());

        // Створюємо Об'єкт 6: автор (Authors)
        Authors author = new Authors();
        author.setId(1L);
        author.setFirstName("Іван");
        author.setLastName("Котляревський");

        // Створюємо Об'єкт 7: публікація (Publications)
        Publications publication = new Publications();
        publication.setId(1L);
        publication.setTitle("Енеїда");
        publication.setIsbn("978-617-679-112-9");
        publication.setPublicationDate(new Date());
        publication.setNumberOfPages(300);

        // Додаємо автора до публікації
        publication.getAuthors().add(author);

        // Додаємо публікацію до автора
        author.getPublications().add(publication);

        System.out.println("Створено Публікацію: " + publication.getTitle());
        System.out.println("Автор: " + publication.getAuthors().iterator().next().getLastName());

        // Створюємо Об'єкт 8: фізичний екземпляр (PublicationInstances)
        PublicationInstances instance = new PublicationInstances();
        instance.setId(1L);
        instance.setInventoryNumber("INV-001A");
        instance.setStatus("Доступна");
        instance.setLocation("Абонемент");
        instance.setCondition("Нова");

        // Встановлюємо, до якої "концепції" книги належить цей екземпляр
        instance.setPublication(publication);

        // Ініціалізуємо список у публікації
        publication.setInstances(new ArrayList<>());
        publication.getInstances().add(instance);

        System.out.println("Створено Екземпляр: " + instance.getInventoryNumber());
        System.out.println("Належить публікації: " + instance.getPublication().getTitle());

        // Створюємо Об'єкт 9: резервація (Reservations)
        Reservations reservation = new Reservations();
        reservation.setId(1L);
        reservation.setReservationDate(new Date());

        reservation.setReader(readerProfile); // Хто резервує
        reservation.setPublicationInstance(instance); // Що резервує

        // Демонструємо зміну даних
        reservation.setStatus("Активна");
        instance.setStatus("Зарезервована"); // Книга тепер зарезервована

        // Додаємо резервацію до списків
        readerProfile.getReservations().add(reservation);
        instance.setReservations(new ArrayList<>());
        instance.getReservations().add(reservation);

        System.out.println("Створено Резервацію (ID: " + reservation.getId() + ")");
        System.out.println("Статус: " + reservation.getStatus());
        System.out.println("Читач: " + reservation.getReader().getUser().getLastName());
        System.out.println("Екземпляр: " + reservation.getPublicationInstance().getInventoryNumber());
        System.out.println("Новий статус екземпляра: " + instance.getStatus());
    }
}
