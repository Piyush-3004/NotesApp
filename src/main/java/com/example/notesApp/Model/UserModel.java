package com.example.notesApp.Model;

import java.time.LocalDate;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.example.notesApp.Dto.UserDto;

import lombok.Data;

@Entity

@Data
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_Id;
	private String firstName;
	private String lastName;
	@CreationTimestamp
	private LocalDate cratedDate;
    @UpdateTimestamp
	private LocalDate udatedDate;
	private String mail;
	private String password;

	public UserModel(UserDto userDto) {	
		this.firstName=userDto.getFirstName();
		this.lastName=userDto.getLastName();
		this.mail=userDto.getMail();
		this.password=userDto.getPassword();
	}

	public UserModel() {
		super();
	}
	
	

}
