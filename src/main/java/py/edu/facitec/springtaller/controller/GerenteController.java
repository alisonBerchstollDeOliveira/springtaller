package py.edu.facitec.springtaller.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.springtaller.dao.GerenteDAO;
import py.edu.facitec.springtaller.model.Gerente;

@Transactional
@Controller
@RestController
@RequestMapping("/gerente")
public class GerenteController {
	@Autowired
	private GerenteDAO dao;
	
	
	//Regitra un producto					//Anotacion que permite cargar los datos al objeto producto
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> registrar(@RequestBody Gerente gerente){
		dao.guardar(gerente, gerente.getId());
		return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
	}
	//Obtiene la lista de producto
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Gerente>> buscarTodo(){
		List<Gerente> gerentes= dao.buscarTodo();
		return new ResponseEntity<List<Gerente>>(gerentes,HttpStatus.OK);
	}
	//Busca un producto por id					//Anotacion que asigna el valor a la variable id
	@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> buscarPorId(@PathVariable Integer id){
		Gerente gerenteBuscado=dao.buscar(id);
		return new ResponseEntity<Gerente>(gerenteBuscado,HttpStatus.OK);
	}
	//Eliminar un producto
	@RequestMapping(method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> eliminar(@PathVariable Integer id){
		Gerente gerenteEliminar= dao.buscar(id);
		if(gerenteEliminar==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dao.eliminar(gerenteEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
