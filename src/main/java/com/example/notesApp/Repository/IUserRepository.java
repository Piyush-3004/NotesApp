package com.example.notesApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notesApp.Model.UserModel;

public interface IUserRepository extends JpaRepository<UserModel , Long>{

	Optional<UserModel> findByMail(String mail);

}
