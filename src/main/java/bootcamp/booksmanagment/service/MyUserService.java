package bootcamp.booksmanagment.service;

import bootcamp.booksmanagment.exsptions.InvalidIdExceptions;
import bootcamp.booksmanagment.model.MyUser;
import bootcamp.booksmanagment.repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserService {
    private final MyUserRepository myUserRepository;
    private final Logger log = LoggerFactory.getLogger(MyUserService.class);
    // find all
    public List<MyUser> getUsers() {
        log.error("Error in get users");
        return myUserRepository.findAll();
    }
    // add user
    public MyUser addUsers(MyUser myUser) {
        log.error("Error in add user");
        return myUserRepository.save(myUser);
    }
    // get user ID
    public MyUser getUsersId(Long userId) {
        log.error("Error in get user ID");
        Optional<MyUser> myUser = myUserRepository.findById(userId);
        if (myUser.isEmpty()){
            throw new InvalidIdExceptions("Invalid ID :(");
        }
        return myUser.get();
    }
}
