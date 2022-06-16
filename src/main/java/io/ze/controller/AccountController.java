package io.ze.controller;

import io.ze.dto.JwtRequest;
import io.ze.dto.JwtResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(consumes = "application/json", produces = "application/json")
public class AccountController {

    @RequestMapping(value = "connexion", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody final JwtRequest authenticationRequest) throws Exception {

        return ResponseEntity.ok(new JwtResponse("token"));
    }
}
