package bootcamp.booksmanagment.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @Positive(message = "ID must be a number")
    private Long loanId;
    private Long userId;
    private Long bookId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId",referencedColumnName = "bookId")
    private Set<Books> books;
}
