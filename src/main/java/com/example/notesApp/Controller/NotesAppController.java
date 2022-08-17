package com.example.notesApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesApp.Dto.NotesAppDto;
import com.example.notesApp.Model.NotesAppModel;
import com.example.notesApp.Service.INotesAppService;

@RestController
@RequestMapping("/notes")
public class NotesAppController {

	@Autowired
	INotesAppService notesAppService;
	
	
	@PostMapping("/create")
	public NotesAppModel create(@RequestHeader String token ,@RequestBody NotesAppDto notesAppDto){
		return notesAppService.create(token,notesAppDto);
		
	}
	
	@GetMapping("/read")
	public List<NotesAppModel> read(@RequestHeader String token) {
		return notesAppService.read(token);
	}
	
	@PutMapping("/update")
	public NotesAppModel update(@RequestHeader String token,@RequestBody NotesAppDto notesAppDto) {
		return notesAppService.update(token,notesAppDto);
	}
	
	
}
