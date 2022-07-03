package dev.mudith.notes.controller;

import dev.mudith.notes.model.User;
import dev.mudith.notes.payload.request.UserRequest;
import dev.mudith.notes.repository.UserRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /* Get All Users */
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    /* Create User */
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){

        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setMobile(userRequest.getMobile());
        user.setPassword(userRequest.getPassword());
        user.setAccountStatus(userRequest.getAccountStatus());
        user.setAccountType(userRequest.getAccountType());

        return ResponseEntity.status(201).body(this.userRepository.save(user));
    }

    /* Get a User by ID */
    @GetMapping("/user/{userId}")
    public ResponseEntity getUserById(@PathVariable String userId){

        Optional<User> user = this.userRepository.findById(userId);

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }else{
            return ResponseEntity.ok("The User with id: " + userId + "was not found...");
        }
    }

    /* Update a User */
    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest, @PathVariable String userId){

        Optional<User> user = this.userRepository.findById(userId);

        if(user.isPresent()){
            User newUpdateUser = user.get();
            newUpdateUser.setFirstName(userRequest.getFirstName());
            newUpdateUser.setLastName(userRequest.getLastName());
            newUpdateUser.setEmail(userRequest.getEmail());
            newUpdateUser.setDateOfBirth(userRequest.getDateOfBirth());
            newUpdateUser.setMobile(userRequest.getMobile());
            newUpdateUser.setPassword(userRequest.getPassword());
            newUpdateUser.setAccountStatus(userRequest.getAccountStatus());
            newUpdateUser.setAccountType(userRequest.getAccountType());

            return ResponseEntity.status(201).body(this.userRepository.save(newUpdateUser));
        }else{
            return null;
        }

    }

    /* Delete a User */
    @DeleteMapping("/user/{userId}")
    public ResponseEntity deleteUserById(@PathVariable String userId){

        Optional<User> user = this.userRepository.findById(userId);

        if(user.isPresent()){
            this.userRepository.deleteById(userId);
            return ResponseEntity.ok("User deleted successfully...");
        }else{
            return ResponseEntity.ok("The User with id: " + userId + "was not found...");
        }
    }
}
