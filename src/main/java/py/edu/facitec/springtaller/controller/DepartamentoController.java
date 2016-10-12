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

import py.edu.facitec.springtaller.dao.DepartamentoDAO;
import py.edu.facitec.springtaller.model.Departamento;
@Transactional
@Controller
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	@Autowired
	private DepartamentoDAO dao;
	
	
	//Regitra un producto					//Anotacion que permite cargar los datos al objeto producto
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> registrar(@RequestBody Departamento departamento){
		dao.guardar(departamento, departamento.getId());
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}
	//Obtiene la lista de producto
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Departamento>> buscarTodo(){
		List<Departamento> departamentos= dao.buscarTodo();
		return new ResponseEntity<List<Departamento>>(departamentos,HttpStatus.OK);
	}
	//Busca un producto por id					//Anotacion que asigna el valor a la variable id
	@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> buscarPorId(@PathVariable Integer id){
		Departamento departamentoBuscado=dao.buscar(id);
		return new ResponseEntity<Departamento>(departamentoBuscado,HttpStatus.OK);
	}
	//Eliminar un producto
	@RequestMapping(method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> eliminar(@PathVariable Integer id){
		Departamento departamentoEliminar= dao.buscar(id);
		if(departamentoEliminar==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dao.eliminar(departamentoEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
