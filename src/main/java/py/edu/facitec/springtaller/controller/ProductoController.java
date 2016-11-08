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
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.springtaller.dao.ProductoDAO;
import py.edu.facitec.springtaller.model.Producto;

@Controller
@Transactional
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoDAO dao;
	
	//Regitra un producto					//Anotacion que permite cargar los datos al objeto producto
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> registrar(@RequestBody Producto producto){
		dao.guardar(producto, producto.getId());
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	//Obtiene la lista de producto
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> buscarTodo(){
		List<Producto> productos = dao.buscarTodo();
		return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
	}
	//Busca un producto por id					//Anotacion que asigna el valor a la variable id
	@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id){
		Producto productoBuscado=dao.buscar(id);
		return new ResponseEntity<Producto>(productoBuscado,HttpStatus.OK);
	}
	//Eliminar un producto
	@RequestMapping(method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> eliminar(@PathVariable Integer id){
		Producto productoEliminar= dao.buscar(id);
		if(productoEliminar==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dao.eliminar(productoEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping("/form")
	public ModelAndView formulario(){
		return new ModelAndView("/productos/form");
		
	}
}
