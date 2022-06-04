package bootcamp.booksmanagment.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @Positive(message = "ID must be a number")
    private Long userId;
    @Column(nullable = false)
    @NotEmpty(message = "user name is required")
    private String username;
    @Column(nullable = false)
    @NotEmpty(message = "password is required")
    @Size(min = 6,message = "Your password must be a 6 char")
    private String password;


    @OneToMany(mappedBy = "myUser",cascade = CascadeType.ALL)
    private Set<Books> books;
}
