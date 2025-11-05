package library.entities;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"publications"}) // Виключаємо Set
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "name") // Назва жанру має бути унікальною

public class Genres {
    private Long id;
    private String name;

    // Асоціація багато-до-багатьох: один жанр може містити багато публікацій
    private Set<Publications> publications = new HashSet<>();
}
