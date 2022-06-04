package bootcamp.booksmanagment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @Positive(message = "ID must be a number")
    private Long bookId;
    @Column(nullable = false)
    @NotEmpty(message = "book Name is required")
    private String bookName;
    @Column(nullable = false)
    @NotEmpty(message = "genre is required")
    private String genre;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private Set<Loan> loan;
    @ManyToOne
    @JsonIgnore
    private MyUser myUser;
}
