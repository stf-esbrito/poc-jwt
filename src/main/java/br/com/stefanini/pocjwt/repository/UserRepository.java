package br.com.stefanini.pocjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.stefanini.pocjwt.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsernameAndPassword(String username, String password);

}
