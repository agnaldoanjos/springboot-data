package com.home.examples;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final SampleService sampleService;

    public UserController(SampleService sampleService) {
        this.sampleService = sampleService;
    }
    @GetMapping("/users/{id}")
    UserDto getUser(@PathVariable Integer id) {
        return sampleService.queryUserById(id);
    }

    @GetMapping("/users")
    List<UserDto> getUsers() {
        return sampleService.queryFromDatabase(100);
    }

    @PostMapping("/user")
    void insert(@RequestBody UserDto user) {
        sampleService.insert(user);
    }

    @PutMapping("/user")
    void update(@RequestBody UserDto user) {
        sampleService.update(user);
    }

    @DeleteMapping("/user")
    void delete(@RequestBody UserDto user) {
        sampleService.update(user);
    }
}
