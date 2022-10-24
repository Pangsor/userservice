package com.test.userservice2.api;

import com.test.userservice2.domain.User;
import com.test.userservice2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @GetMapping("/jobs")
    public List<Object> getJobs(){
        String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
        RestTemplate restTemplate = new RestTemplate();
        Object[] result = restTemplate.getForObject(uri, Object[].class);
        return Arrays.asList(result);
    }

    @GetMapping("/job/{id}")
    public List<Object> getJob(){
        String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Object[] result = restTemplate.getForObject(uri, Object[].class);
        return Arrays.asList(result);
    }
}
