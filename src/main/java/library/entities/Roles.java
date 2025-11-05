package library.entities;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = {"users"}) // Виключаємо Set, щоб уникнути циклів
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "roleName") // Унікальний ключ для порівняння

public class Roles {
    private Long id;
    private String roleName; // Напр. бібліотекар

    // Асоціація багато-до-багатьох: одна роль може належати багатьом користувачам
    private Set<Users> users = new HashSet<>();
}
