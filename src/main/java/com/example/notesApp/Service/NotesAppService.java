package com.example.notesApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesApp.Dto.NotesAppDto;
import com.example.notesApp.Model.NotesAppModel;
import com.example.notesApp.Model.UserModel;
import com.example.notesApp.Repository.INotesAppRepository;
import com.example.notesApp.Repository.IUserRepository;
import com.example.notesApp.Util.TokenUtil;

@Service
public class NotesAppService implements INotesAppService{

	@Autowired 
	INotesAppRepository notesAppRepository;
	
	@Autowired
	TokenUtil tokenUtil;
	
	@Autowired
	IUserRepository userRepo;

	@Override
	public NotesAppModel create(String token, NotesAppDto notesAppDto) {
		
		long userId = tokenUtil.decodeToken(token);
		Optional<UserModel> user = userRepo.findById(userId);
		NotesAppModel note = new NotesAppModel();
		note.setLabel(notesAppDto.getLabel());
		note.setNote(notesAppDto.getNote());		
		note.setUser(user.get());
		notesAppRepository.save(note);
		return note;
	}

	
	
	@Override
	public NotesAppModel update(String token, NotesAppDto notesAppDto) {
		long id = tokenUtil.decodeToken(token);
		Optional<NotesAppModel> note = notesAppRepository.findByUser(id);
		note.get().setLabel(notesAppDto.getLabel());
		note.get().setNote(notesAppDto.getNote());
		notesAppRepository.save(note.get());
		return note.get();
	}



	@Override
	public NotesAppModel read(String token) {
		long id = tokenUtil.decodeToken(token);
		Optional<NotesAppModel> note = notesAppRepository.findByUser(id);
		
		return note.get();
	}
	
	
}
