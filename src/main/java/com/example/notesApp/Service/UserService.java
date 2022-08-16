package com.example.notesApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesApp.Dto.UserDto;
import com.example.notesApp.Model.UserModel;
import com.example.notesApp.Repository.IUserRepository;
import com.example.notesApp.Util.Response;
import com.example.notesApp.Util.TokenUtil;

@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	TokenUtil tokenUtil;
	
	@Autowired
	MailService mailService;

	@Override
	public UserModel create(UserDto userDto) {
		UserModel userModel = new UserModel(userDto);
		userRepository.save(userModel);
		return userModel;
	}

	@Override
	public List<UserModel> readAll() {
		List<UserModel> list =userRepository.findAll();
		return list;
	}

	@Override
	public UserModel update(UserDto userDto,long id) {
		Optional<UserModel> isUserPresent = userRepository.findById(id);
		
		isUserPresent.get().setFirstName(userDto.getFirstName());
		isUserPresent.get().setLastName(userDto.getLastName());
		isUserPresent.get().setMail(userDto.getMail());
		isUserPresent.get().setPassword(userDto.getPassword());
		userRepository.save(isUserPresent.get());
		
		return isUserPresent.get();
	}

	@Override
	public UserModel delete(long id) {
		Optional<UserModel> isUserPresent = userRepository.findById(id);
		userRepository.delete(isUserPresent.get());
		return isUserPresent.get();
	}

	@Override
	public Response login(String mail, String password) {
		Optional<UserModel> user = userRepository.findByMail(mail);
		if(user.get().getPassword().equals(password)) {
			String token = tokenUtil.createToken(user.get().getUser_Id());
			return new Response(100,"Login Successful",token);
		}else
		return new Response("Could not login");
	}

	@Override
	public UserModel deletebytoken(String token) {
		long userId = tokenUtil.decodeToken(token);
		Optional<UserModel> user = userRepository.findById(userId);
		userRepository.delete(user.get());
		return user.get();
	}

	@Override
	public UserModel updateBytoken(String token ,UserDto userDto) {
		long userId = tokenUtil.decodeToken(token);
		Optional<UserModel> user = userRepository.findById(userId);
		user.get().setFirstName(userDto.getFirstName());
		user.get().setLastName(userDto.getLastName());
		user.get().setMail(userDto.getMail());
		user.get().setPassword(userDto.getPassword());
		userRepository.save(user.get());
		return user.get();
	}

	@Override
	public UserModel readByToken(String token) {
		long userId = tokenUtil.decodeToken(token);
		Optional<UserModel> data = userRepository.findById(userId);
		if(data.isPresent())
			return data.get();
		return null;
	}

	@Override
	public void sendMail(String mail, String subject, String body) {
		Optional<UserModel> user =userRepository.findByMail(mail);
		if(user.isPresent()) {
			mailService.send(mail, subject, body);
		}
		
	}

}
