package net.javaguides.springbootkafkatutorial.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {
    private int id;
    private String firstName;
    private String lastName;
}