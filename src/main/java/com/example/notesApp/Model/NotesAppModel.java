package com.example.notesApp.Model;

import java.time.LocalDate;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.notesApp.Dto.NotesAppDto;
import com.example.notesApp.Dto.UserDto;

import lombok.Data;

@Entity

@Data
public class NotesAppModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_Id;
	private String note;
	@CreationTimestamp
	private LocalDate createdTime;
	@UpdateTimestamp
	private LocalDate updateTime;
	private String label;
	@OneToOne
	UserModel user;

	public NotesAppModel(NotesAppDto notesAppDto) {
		this.note=notesAppDto.getNote();
		this.label=notesAppDto.getLabel();
		UserModel userModel1 = mapUserModel(notesAppDto.getUser());
		this.user =userModel1;
	}
	 public UserModel mapUserModel(UserDto user) {
	        UserModel user1=new UserModel();
	        user1.setFirstName(user.getFirstName());
	        user1.setLastName(user.getLastName());
	        user1.setMail(user.getMail());
	        user1.setPassword(user.getPassword());
	        return user1;
	    }
	
	public NotesAppModel() {
		// TODO Auto-generated constructor stub
	}

}
