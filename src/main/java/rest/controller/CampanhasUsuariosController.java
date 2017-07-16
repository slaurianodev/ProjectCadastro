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
import java.util.List;


import rest.model.CampanhasUsuarios;
import rest.repository.CampanhasUsuariosRepository;

@Controller
@RequestMapping(path="/rest-campanhas-usuarios")
public class CampanhasUsuariosController {
	@Autowired
	private CampanhasUsuariosRepository campanhasUsuariosRepository;

	@GetMapping(path="/getAllCampanhasUsuarios")
	public @ResponseBody Iterable<CampanhasUsuarios> getAllCampanhasUsuarios() {
		// This returns a JSON or XML with the users
		return campanhasUsuariosRepository.findAll();
	}

	@GetMapping(path="/getCampanhasUsuariosById/{id}")
	public ResponseEntity getUserById(@PathVariable Long id) {

		if(!campanhasUsuariosRepository.exists(id)){
			return new ResponseEntity("Usuario nao encontrado :(.\n ID informado: " + id, HttpStatus.NOT_FOUND);
		} else{
			return new ResponseEntity(campanhasUsuariosRepository.findOne(id),HttpStatus.OK);
		}

	}

	@PostMapping(path="/createNewCampanhasUsuarios")
	public ResponseEntity createNewCampanhasUsuarios(@RequestBody CampanhasUsuarios campanhasUsuarios){

			try{
				campanhasUsuariosRepository.save(campanhasUsuarios);
				return new ResponseEntity("Campanha cadastrada com sucesso! ;)", HttpStatus.OK);
			}catch(Exception ex){
				return new ResponseEntity("Ocorreu um erro a criar a campanha. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

	}

	@DeleteMapping(path="/deleteCampanhasUsuarios/{id}")
	public ResponseEntity deleteCampanhasUsuarios(@PathVariable Long id) {

		try{
			campanhasUsuariosRepository.delete(id);
			return new ResponseEntity("Campanha deletada com sucesso! ;)", HttpStatus.OK);
		} catch(Exception ex){
			return new ResponseEntity("Ocorreu um erro a deletar a campanha. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
