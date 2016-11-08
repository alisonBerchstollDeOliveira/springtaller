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

import py.edu.facitec.springtaller.dao.UsuarioDAO;
import py.edu.facitec.springtaller.model.Usuario;

@Transactional
@Controller
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioDAO dao;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
		dao.guardar(usuario, usuario.getLogin());
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> buscarTodo(){
		List<Usuario> usuarios= dao.buscarTodo();
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarPorId(@PathVariable String login){
		Usuario usuarioBuscado=dao.buscar(login);
		return new ResponseEntity<Usuario>(usuarioBuscado,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> eliminar(@PathVariable String login){
		Usuario usuarioEliminar= dao.buscar(login);
		if(usuarioEliminar==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dao.eliminar(usuarioEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping("/form")
	public ModelAndView formulario(){
		return new ModelAndView("/usuarios/form");
		
	}
	
}
