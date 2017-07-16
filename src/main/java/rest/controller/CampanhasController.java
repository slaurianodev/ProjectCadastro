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

			try{
				campanhasRepository.save(campanha);
				return new ResponseEntity("Campanha cadastrada com sucesso! ;)" + campanha.getDataFim(), HttpStatus.OK);
			}catch(Exception ex){
				return new ResponseEntity("Ocorreu um erro a criar a campanha. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

	}

	@PutMapping(path="/updateUser/{id}")
	public ResponseEntity updateCampanha(@PathVariable Long id,@RequestBody Campanhas campanha) {

		Campanhas campanhaOld = null;

		if(!campanhasRepository.exists(id)){
			return new ResponseEntity("Campanha nao encontrada :(.\n ID informado: " + id, HttpStatus.NOT_FOUND);
		} else {
			campanhaOld = campanhasRepository.findOne(id);
			campanhaOld.setNomeCampanha(campanha.getNomeCampanha());
			campanhaOld.setIdTimeCoracao(campanha.getIdTimeCoracao());
			campanhaOld.setDataInicio(campanha.getDataInicio());
			campanhaOld.setDataFim(campanha.getDataFim());

		}

		try{
			campanhasRepository.save(campanhaOld);
			return new ResponseEntity("Campanha atualizada com sucesso! ;)", HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity("Ocorreu um erro a atualizar a campanha. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(path="/deleteCampanha/{id}")
	public ResponseEntity deleteCampanha(@PathVariable Long id) {

		try{
			campanhasRepository.delete(id);
			return new ResponseEntity("Campanha deletada com sucesso! ;)", HttpStatus.OK);
		} catch(Exception ex){
			return new ResponseEntity("Ocorreu um erro a deletar a campanha. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
