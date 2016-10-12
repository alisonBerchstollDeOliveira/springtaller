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

import py.edu.facitec.springtaller.dao.ItemPedidoDAO;
import py.edu.facitec.springtaller.model.ItemPedido;

@Transactional
@Controller
@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {
	@Autowired
	private ItemPedidoDAO dao;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> registrar(@RequestBody ItemPedido itemPedido){
		dao.guardar(itemPedido, itemPedido.getId());
		return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemPedido>> buscarTodo(){
		List<ItemPedido> itemPedidos= dao.buscarTodo();
		return new ResponseEntity<List<ItemPedido>>(itemPedidos,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Integer id){
		ItemPedido itemPedidoBuscado=dao.buscar(id);
		return new ResponseEntity<ItemPedido>(itemPedidoBuscado,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> eliminar(@PathVariable Integer id){
		ItemPedido itemPedidoEliminar= dao.buscar(id);
		if(itemPedidoEliminar==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dao.eliminar(itemPedidoEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
