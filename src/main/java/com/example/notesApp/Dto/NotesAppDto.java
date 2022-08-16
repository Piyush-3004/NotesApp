package com.example.notesApp.Dto;

import com.example.notesApp.Model.UserModel;

import lombok.Data;

@Data
public class NotesAppDto {
	
	private String note;
	private String label;

	private UserDto user;
}
