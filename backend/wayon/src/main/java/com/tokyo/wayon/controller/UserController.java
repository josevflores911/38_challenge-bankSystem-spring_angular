package com.tokyo.wayon.controller;



import com.tokyo.wayon.model.user.User;
import com.tokyo.wayon.model.user.UserData;
import com.tokyo.wayon.model.user.UserDetail;
import com.tokyo.wayon.model.user.UserDetailRequest;
import com.tokyo.wayon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getall")
    @Operation(summary = "Get the entire list of users")
    public ResponseEntity<List<UserDetail>> showUserList(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = userRepository.findAll().stream().map(UserDetail::new).collect(Collectors.toList());

        return ResponseEntity.ok(page);
    }

    @PostMapping("/account")
    @Operation(summary = "Get user by Account")
    public ResponseEntity<UserDetail> userDetailByAccount(@RequestBody UserDetailRequest userDTO) {
        try {
            var user = userRepository.findByAccountAndUserkey(userDTO.account(), userDTO.userkey());
            return ResponseEntity.ok(new UserDetail(user));
        }catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
        }
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get user by Id")
    public ResponseEntity<UserDetail> userDetailById(@PathVariable UUID id) {

        var user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new UserDetail(user));
    }


    @PutMapping
    @Transactional
    @Operation(summary = "Update a user")
    public ResponseEntity<UserDetail> updateUser(@RequestBody @Valid UserDetail data) {

        var user = userRepository.getReferenceById(data.id());
        //user.update(data);

        return ResponseEntity.ok(new UserDetail(user));
    }

    //----------not used
    @PostMapping
    @Transactional
    @Operation(summary = "Add a new User")
    public ResponseEntity<UserDetail> addUser(@RequestBody @Valid UserData data, UriComponentsBuilder uriBuilder) {

        var user = new User(data);
        userRepository.save(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetail(user));
    }



    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Remove a user")
    public ResponseEntity<UserDetail> removeUser(@PathVariable UUID id) {

        var user = userRepository.getReferenceById(id);
        user.delete();

        return ResponseEntity.noContent().build();

    }



//    @GetMapping("/getall")
//    @Operation(summary = "Get the entire list of users")
//    public ResponseEntity<Page<UserDetail>> showUserList(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
//        var page = userRepository.findAllByActivoTrue(pagination).map(UserDetail::new);
//        var page = userRepository.findAll(pagination).map(UserDetail::new);
//
//        return ResponseEntity.ok(page);
//    }
}