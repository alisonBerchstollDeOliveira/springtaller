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

import py.edu.facitec.springtaller.dao.PedidoDAO;
import py.edu.facitec.springtaller.model.Pedido;

@Transactional
@Controller
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoDAO dao;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido){
		dao.guardar(pedido, pedido.getId());
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pedido>> buscarTodo(){
		List<Pedido> pedidos= dao.buscarTodo();
		return new ResponseEntity<List<Pedido>>(pedidos,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id){
		Pedido pedidoBuscado=dao.buscar(id);
		return new ResponseEntity<Pedido>(pedidoBuscado,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> eliminar(@PathVariable Long id){
		Pedido pedidoEliminar= dao.buscar(id);
		if(pedidoEliminar==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dao.eliminar(pedidoEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping("/form")
	public ModelAndView formulario(){
		return new ModelAndView("/pedidos/form");
		
	}
}
