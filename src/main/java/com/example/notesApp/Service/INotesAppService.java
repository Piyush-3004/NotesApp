package com.example.notesApp.Service;

import com.example.notesApp.Dto.NotesAppDto;
import com.example.notesApp.Model.NotesAppModel;

public interface INotesAppService {


	NotesAppModel create(String token, NotesAppDto notesAppDto);

	NotesAppModel update(String token, NotesAppDto notesAppDto);

	NotesAppModel read(String token);

}
