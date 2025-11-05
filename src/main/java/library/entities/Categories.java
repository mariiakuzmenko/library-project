package library.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = {"publications"}) // Виключаємо List
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "name") // Назва категорії має бути унікальною

public class Categories {
    private Long id;
    private String name; // "Книга", "Журнал"
    private String description;

    // Асоціація: 1-до-багатьох: одна категорія може мати багато публікацій
    private List<Publications> publications;
}
