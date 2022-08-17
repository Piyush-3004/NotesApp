package com.example.notesApp.Service;

import java.util.List;

import com.example.notesApp.Dto.NotesAppDto;
import com.example.notesApp.Model.NotesAppModel;

public interface INotesAppService {


	NotesAppModel create(String token, NotesAppDto notesAppDto);

	NotesAppModel update(String token, NotesAppDto notesAppDto);

	List<NotesAppModel> read(String token);

}
