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


import rest.model.Campanhas;
import rest.repository.CampanhasRepository;

@Controller
@RequestMapping(path="/rest-campanhas")
public class CampanhasController {
	@Autowired
	private CampanhasRepository campanhasRepository;

	@GetMapping(path="/getAllCampanhas")
	public @ResponseBody Iterable<Campanhas> getAllCampanhas() {
		// This returns a JSON or XML with the users
		return campanhasRepository.findAll();
	}

	@GetMapping(path="/getUserById/{id}")
	public ResponseEntity getUserById(@PathVariable Long id) {

		if(!campanhasRepository.exists(id)){
			return new ResponseEntity("Usuario nao encontrado :(.\n ID informado: " + id, HttpStatus.NOT_FOUND);
		} else{
			return new ResponseEntity(campanhasRepository.findOne(id),HttpStatus.OK);
		}

	}

	@PostMapping(path="/createNewCampanha")
	public ResponseEntity createNewCampanha(@RequestBody Campanhas campanha){

			Campanhas camp = campanha;

			try{
				System.out.println(camp.getDataFim());
				List<Campanhas> listCampanhas = campanhasRepository.findAllByDataFim(campanha.getDataFim());
				if(listCampanhas.size()>0){
					System.out.println(listCampanhas.size());
				}
				for(Campanhas cp : listCampanhas){
					System.out.println(cp.getNomeCampanha());
				}

				campanhasRepository.save(campanha);
				return new ResponseEntity("Campanha cadastrada com sucesso! ;)" + campanha.getDataFim(), HttpStatus.OK);
			}catch(Exception ex){
				return new ResponseEntity("Ocorreu um erro a criar a campanha. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

	}

	// @PutMapping(path="/updateUser/{id}")
	// public ResponseEntity updateUser(@PathVariable Long id,@RequestBody Campanhas user) {
	//
	// 	Campanhas userOld = null;
	//
	// 	if(!campanhasRepository.exists(id)){
	// 		return new ResponseEntity("Usuario nao encontrado :(.\n ID informado: " + id, HttpStatus.NOT_FOUND);
	// 	} else {
	// 		userOld = campanhasRepository.findOne(id);
	// 		userOld.setNomeCompleto(user.getNomeCompleto());
	// 		userOld.setEmail(user.getEmail());
	// 		userOld.setDataNascimento(user.getDataNascimento());
	// 		userOld.setIdTimeCoracao(user.getIdTimeCoracao());
	// 	}
	//
	// 	try{
	// 		campanhasRepository.save(userOld);
	// 		return new ResponseEntity("Usuario atualizado com sucesso! ;)", HttpStatus.OK);
	// 	}catch(Exception ex){
	// 		return new ResponseEntity("Ocorreu um erro a atualizar o usuario. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	//
	// }

	@DeleteMapping(path="/deleteCampanha/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {

		try{
			campanhasRepository.delete(id);
			return new ResponseEntity("Campanha deletada com sucesso! ;)", HttpStatus.OK);
		} catch(Exception ex){
			return new ResponseEntity("Ocorreu um erro a deletar a campanha. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
