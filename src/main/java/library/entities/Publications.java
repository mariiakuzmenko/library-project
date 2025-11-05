package library.entities;

import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = {"category", "publisher", "instances", "authors", "genres"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "isbn") // ISBN - ідеальний унікальний ключ

public class Publications {
    private Long id;
    private String title;
    private String isbn; // International Standard Book Number
    private Date publicationDate;
    private String summary;
    private String language;
    private int numberOfPages;

    // Асоціація багато-до-1: багато публікацій належать одній категорії
    private Categories category;

    // Асоціація багато-до-1: багато публікацій належать одному видавництву
    private Publishers publisher;

    // Асоціація 1-до-багатьох: одна публікація (концепція) має багато фізичних екземплярів
    private List<PublicationInstances> instances;

    // Асоціація багато-до-багатьох: одну публікацію можуть написати багато авторів
    private Set<Authors> authors = new HashSet<>();

    // Асоціація багато-до-багатьох: одна публікація може належати багатьом жанрам
    private Set<Genres> genres = new HashSet<>();

}
