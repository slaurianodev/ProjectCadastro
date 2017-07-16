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

import rest.model.TimeCoracao;
import rest.repository.TimeCoracaoRepository;

@Controller
@RequestMapping(path="/rest-time")
public class TimesController {
	@Autowired
	private TimeCoracaoRepository timeCoracaoRepository;

	@GetMapping(path="/getAllTimes")
	public @ResponseBody Iterable<TimeCoracao> getAllTimes() {
		return timeCoracaoRepository.findAll();
	}

	@GetMapping(path="/getTimeById/{id}")
	public ResponseEntity getTimeById(@PathVariable Long id) {

		if(!timeCoracaoRepository.exists(id)){
			return new ResponseEntity("Usuario nao encontrado :(.\n ID informado: " + id, HttpStatus.NOT_FOUND);
		} else{
			return new ResponseEntity(timeCoracaoRepository.findOne(id),HttpStatus.OK);
		}

	}

	@PostMapping(path="/createNewTime")
	public ResponseEntity createNewTime(@RequestBody TimeCoracao timeCoracao){

			try{
				timeCoracaoRepository.save(timeCoracao);
				return new ResponseEntity("Time cadastrado com sucesso! ;)", HttpStatus.OK);
			}catch(Exception ex){
				return new ResponseEntity("Ocorreu um erro a criar o usuario. :( \n" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

	}

}
