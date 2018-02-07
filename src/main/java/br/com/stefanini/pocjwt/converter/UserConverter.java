package br.com.stefanini.pocjwt.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.pocjwt.dto.UserDTO;
import br.com.stefanini.pocjwt.model.User;

public class UserConverter {

	public static UserDTO objToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}
	
	public static User objToModel(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		return user;
	}
	
	public static List<UserDTO> toDTO(List<User> users){
		List<UserDTO> usersDTO = new ArrayList<>();
		users.forEach(user -> {
			usersDTO.add(objToDTO(user));
		});
		return usersDTO;
	}
	
	public static List<User> toUser(List<UserDTO> usersDTO) {
		List<User> users = new ArrayList<>();
		usersDTO.forEach(userDTO -> {
			users.add(objToModel(userDTO));
		});
		return users;
	}
	
}
