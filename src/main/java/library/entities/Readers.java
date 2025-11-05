package library.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString(exclude = {"user", "reservations"}) // Виключаємо зв'язки
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "libraryCardNumber") // Унікальний ключ

public class Readers {
    private Long id;
    private String libraryCardNumber; // Номер читацької картки
    private Date openedDate; // Коли читач приєднався до бібліотеки
    private double balance = 0.0; // Для штрафів за несвоєчасне повернення літератури до бібліотеки

    // Асоціація 1-до-1: цей профіль читача належить одному юзеру
    private Users user;

    // Асоціація 1-до-багатьох: один читач може мати багато резервацій
    private List<Reservations> reservations = new ArrayList<>();
}
