package library.entities;

import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"publications"}) // Виключаємо Set
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Authors {
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;
    private Date dateOfBirth;

    // Асоціація багато-до-багатьох: один автор може написати багато публікацій
    private Set<Publications> publications = new HashSet<>();
}
