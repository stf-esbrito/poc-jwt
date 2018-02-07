package br.com.stefanini.pocjwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.pocjwt.converter.UserConverter;
import br.com.stefanini.pocjwt.dto.UserDTO;
import br.com.stefanini.pocjwt.model.User;
import br.com.stefanini.pocjwt.repository.UserRepository;
import br.com.stefanini.pocjwt.security.TokenAuthenticationService;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public List<UserDTO> findAll(){
		return UserConverter.toDTO(userRepository.findAll());
	}

	public String login(UserDTO userDTO) {
		User user = UserConverter.objToModel(userDTO);
		UserDTO account = UserConverter.objToDTO(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
		return account != null ? TokenAuthenticationService.addAuthentication(account.getUsername()) : null;
	}
}
