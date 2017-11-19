package com.team.framenb.repository;

import com.team.framenb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

    public User findByName(String name);

    public List<User> findAllByName(String name);

    public User findById(Integer userId);
}
