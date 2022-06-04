package bootcamp.booksmanagment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ApiResponce {
    private String message;
    private Integer status;
}
