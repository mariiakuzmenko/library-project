package library.entities;

import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"roles"}) // Виключаємо Set, щоб уникнути циклів
@EqualsAndHashCode(of = "username") // Унікальний ключ для порівняння

public class Users {

    private Long id;
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private boolean isActive; // true = активний, false = заблокований
    private Date createdDate; // Коли акаунт створено

    // Асоціація багато-до-багатьох: один користувач може мати багато ролей
    private Set<Roles> roles = new HashSet<>();
}
