package com.orange.sonatel.malado.dao;

import com.orange.sonatel.malado.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findById(int id);


}
