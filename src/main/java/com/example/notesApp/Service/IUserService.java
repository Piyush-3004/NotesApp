package com.example.notesApp.Service;

import java.util.List;

import com.example.notesApp.Dto.UserDto;
import com.example.notesApp.Model.UserModel;
import com.example.notesApp.Util.Response;

public interface IUserService {

	UserModel create(UserDto userDto);

	List<UserModel> readAll();

	UserModel update(UserDto userDto, long id);

	UserModel delete(long id);

	Response login(String mail, String password);

	UserModel deletebytoken(String token);

	UserModel updateBytoken(String token, UserDto userDto);

	UserModel readByToken(String token);

	void sendMail(String mail, String subject, String body);

}
