package library.entities;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Reservations {
    private Long id;
    private String status; // Наприклад: "Активна", "Закрита", "Протермінована"

    private Date reservationDate; // Коли замовили (створили резерв)
    private Date issueDate; // Коли бібліотекар видав книгу
    private Date dueDate; // До якої дати треба повернути
    private Date returnDate; // Коли фактично повернули

    // Асоціація багато-до-1: багато резервацій належить одному профілю читача
    private Readers reader;

    // Асоціація багато-до-1: багато резервацій стосуються одного екземпляра
    private PublicationInstances publicationInstance;
}
