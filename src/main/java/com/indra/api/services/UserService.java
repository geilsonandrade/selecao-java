package com.indra.api.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.api.domain.User;
import com.indra.api.dto.UserDTO;
import com.indra.api.repositories.UserRepository;
import com.indra.api.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(long id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) throws NoSuchAlgorithmException {
		return repo.save(encryptPassword(obj));
	}

	public void delete(long id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) throws NoSuchAlgorithmException {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(encryptPassword(newObj));
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	private User encryptPassword(User obj) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		md.update(obj.getPassword().getBytes());
		obj.setPassword(md.digest().toString());
		return obj;
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getCpf(), objDto.getName(), objDto.getEmail(), objDto.getPassword());
	}
}
