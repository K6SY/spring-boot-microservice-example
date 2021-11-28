package com.orange.sonatel.malado.web.controller;

import com.orange.sonatel.malado.dao.UserDao;
import com.orange.sonatel.malado.model.User;
import com.orange.sonatel.malado.web.exceptions.UserIntrouvableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="/registers", method= RequestMethod.GET)
    public List<User> listRegister() {
        return userDao.findAll();
    }


    @PostMapping(value = "/register")
    public ResponseEntity<Void> ajouterProduit(@RequestBody User user) {
        User userAdded = userDao.save(user);
        if (userAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //Récupérer un produit par son Id
    @GetMapping(value="/register/{id}")
    public User showUser(@PathVariable int id) {
        User user= userDao.findById(id);
        System.out.println(user);
        if(user==null)
            throw new UserIntrouvableException("L'utilisateur avec l'id " + id + " est UNPROVABLE. Écran Bleu si je pouvais.");

        return user;
    }

}
