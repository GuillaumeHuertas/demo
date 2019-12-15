package com.example.demo.controller;

import com.example.demo.dto.JeuxVideoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class JeuxVideoController {

    @GetMapping("/test")
    public ResponseEntity testApplication () {


        return new ResponseEntity( "Coucou", HttpStatus.OK);
    }

    @PostMapping("/ajouterJeuxVideo")
    public ResponseEntity ajouterJeuxVideo(@RequestBody JeuxVideoDTO pJeuxVideo) {

        String res = pJeuxVideo.toString();

        log.info(res + "\"" + pJeuxVideo.jeuxVideoDetails());


//        return new ResponseEntity( res, HttpStatus.OK);
        return new ResponseEntity<>( pJeuxVideo, HttpStatus.OK);
    }

    // Setter pour le service
}
