package bootcamp.booksmanagment.controller;
import bootcamp.booksmanagment.dto.ApiResponce;
import bootcamp.booksmanagment.model.MyUser;
import bootcamp.booksmanagment.service.MyUserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class MyUserController {
    private final MyUserService myUserService;
    private final Logger log = LoggerFactory.getLogger(MyUserController.class);
    // find all
    @GetMapping
    public List<MyUser> getUsers(){
        log.info("get All users");
        return myUserService.getUsers();
    }
    // add user
    @PostMapping
    public ResponseEntity<ApiResponce> addUsers(@RequestBody @Valid MyUser myUser){
        myUserService.addUsers(myUser);
        log.info("add user");
        return ResponseEntity.status(201).body(new ApiResponce("your request Accspted :)",201));
    }
    // get user ID
    @GetMapping("/userid")
    public ResponseEntity<MyUser> getUsersId(Long userId){
        log.info("get user ID");
        return ResponseEntity.status(200).body(myUserService.getUsersId(userId));
    }
}
