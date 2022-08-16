package com.example.notesApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notesApp.Model.NotesAppModel;

public interface INotesAppRepository extends JpaRepository<NotesAppModel , Long>{

	Optional<NotesAppModel> findByUser(long id);

}
