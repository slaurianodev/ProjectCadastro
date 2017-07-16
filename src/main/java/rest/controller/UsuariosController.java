package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;


import rest.model.Usuarios;
import rest.repository.UsuariosRepository;

@Controller
@RequestMapping(path="/rest-user")
public class UsuariosController {
	@Autowired
	private UsuariosRepository usuariosRepository;

	@GetMapping(path="/getAllUsers")
	public @ResponseBody Iterable<Usuarios> getAllUsers() {
		// This returns a JSON or XML with the users
		return usuariosRepository.findAll();
	}

	@GetMapping(path="/getUserById/{id}")
	public ResponseEntity getUserById(@PathVariable Long id) {

		if(!usuariosRepository.exists(id)){
			return new ResponseEntity("Usuario nao encontrado :(.\n ID informado: " + id, HttpStatus.NOT_FOUND);
		} else{
			return new ResponseEntity(usuariosRepository.findOne(id),HttpStatus.OK);
		}

	}

	@PostMapping(path="/createNewUser")
	public ResponseEntity createNewUser(@RequestBody Usuarios user){

			try{
				usuariosRepository.save(user);
				return new ResponseEntity("Usuario cadastrado com sucesso! ;)", HttpStatus.OK);
			}catch(Exception ex){
				return new ResponseEntity("Ocorreu um erro a criar o usuario. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

	}

	@PutMapping(path="/updateUser/{id}")
	public ResponseEntity updateUser(@PathVariable Long id,@RequestBody Usuarios user) {

		Usuarios userOld = null;

		if(!usuariosRepository.exists(id)){
			return new ResponseEntity("Usuario nao encontrado :(.\n ID informado: " + id, HttpStatus.NOT_FOUND);
		} else {
			userOld = usuariosRepository.findOne(id);
			userOld.setNomeCompleto(user.getNomeCompleto());
			userOld.setEmail(user.getEmail());
			userOld.setDataNascimento(user.getDataNascimento());
			userOld.setIdTimeCoracao(user.getIdTimeCoracao());
		}

		try{
			usuariosRepository.save(userOld);
			return new ResponseEntity("Usuario atualizado com sucesso! ;)", HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity("Ocorreu um erro a atualizar o usuario. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(path="/deleteUser/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {

		try{
			usuariosRepository.delete(id);
			return new ResponseEntity("Usuario deletado com sucesso! ;)", HttpStatus.OK);
		} catch(Exception ex){
			return new ResponseEntity("Ocorreu um erro a deletar o usuario. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
