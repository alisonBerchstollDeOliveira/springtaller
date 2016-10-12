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
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.springtaller.dao.ClienteDAO;
import py.edu.facitec.springtaller.model.Cliente;
//Gestionar transaciones
@Transactional
@Controller
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteDAO clienteDAO;
					//responder a peticiones post
	@RequestMapping(method=RequestMethod.POST)
	//Viene los datos del formulario y se pasa al objeto
	public String save(@RequestBody Cliente cliente){
		clienteDAO.guardar(cliente, cliente.getId());
		System.out.println("Registrado el cliente: "+cliente);
		return "/clientes/ok";
	}
	
	@RequestMapping(value="/formulario",method=RequestMethod.GET)
	public String formulario(){
		return "/clientes/formulario";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista(){
		//Crear el archivo lista para visualizar los datos en jsp
		ModelAndView model = new ModelAndView("/clientes/lista");
		//Agregamos la lista de clientes al objeto que contendra la vista
		model.addObject("clientes", clienteDAO.buscarTodo());
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> buscarTodo(){
		List<Cliente> clientes= clienteDAO.buscarTodo();
		return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
		Cliente clienteBuscado=clienteDAO.buscar(id);
		return new ResponseEntity<Cliente>(clienteBuscado,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> eliminar(@PathVariable Integer id){
		Cliente clienteEliminar= clienteDAO.buscar(id);
		if(clienteEliminar==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteDAO.eliminar(clienteEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
//Crear el metodo para acceder al formulario