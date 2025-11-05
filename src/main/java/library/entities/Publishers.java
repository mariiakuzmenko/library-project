package library.entities;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"publications"}) // Виключаємо List
@EqualsAndHashCode(of = "name") // Назва видавництва має бути унікальною

public class Publishers {
    private Long id;
    private String name;
    private String address;
    private String description;

    // Асоціація 1-до-багатьох: одне видавництво може мати багато публікацій
    private List<Publications> publications;
}
