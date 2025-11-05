package library.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = {"publication", "reservations"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "inventoryNumber") // Інв. номер - унікальний

public class PublicationInstances {
    private Long id;
    private String inventoryNumber; // Інвентарний номер
    private String status; // "Доступна", "Зарезервована", "На руках"
    private String location; // "Абонемент", "Читальний зал"
    private String condition; // "Нова", "Добра", "Потребує ремонту"

    // Асоціація багато-до-1: багато екземплярів належать одній публікації (концепції)
    private Publications publication;

    // Асоціація 1-до-багатьох: один екземпляр може мати багато резервацій (історія)
    private List<Reservations> reservations;
}
