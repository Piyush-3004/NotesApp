package com.example.notesApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.notesApp.Dto.UserDto;
import com.example.notesApp.Model.UserModel;
import com.example.notesApp.Service.IUserService;
import com.example.notesApp.Util.Response;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
//CRUD operations	
	// accept Body and store to db , requires firstName , lastName , mail , password in body.
	@PostMapping("/create")
	public UserModel create(@RequestBody UserDto UserDto) {
		return userService.create(UserDto);
	}
	
	// Read all users data List
	@GetMapping("/read")
	public List<UserModel> readAll(){
		return userService.readAll();
	}
	
	@GetMapping("/readbytoken")
	public UserModel readByToken(@RequestHeader String token) {
		return userService.readByToken(token);
	}
	
	// Update data , requires: firstName , lastName , mail , password in body.
	@PutMapping("/update/{id}")
	public UserModel update(@RequestBody UserDto userDto, @PathVariable long id) {
		return userService.update(userDto,id);
	}
	
	@PutMapping("/updatebytoken")
	public UserModel updateByToken(@RequestHeader String token,@RequestBody UserDto userDto) {
		return userService.updateBytoken(token,userDto);
	}	
		
	@DeleteMapping("/delete/{id}")
	public UserModel delete(@PathVariable long id) {
		return userService.delete(id);
	}

	@DeleteMapping("deletebytoken")
	public UserModel deletebytoken(@RequestHeader String token) {
		return userService.deletebytoken(token);
	}
	
//jwt implementation 
	
	@PostMapping("/login")
	public Response login(@RequestHeader String mail,@RequestHeader String password) {
		return userService.login(mail,password);
	}
	
//jms implementaton
	// mail will be sent only if the mail is present in database 
	@PostMapping("/sendmail")
	public void sendMail(@RequestHeader String mail,@RequestHeader String subject,@RequestHeader String body) {
		userService.sendMail(mail,subject,body);
	}
	
}
