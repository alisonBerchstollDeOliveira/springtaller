package py.edu.facitec.springtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.edu.facitec.springtaller.dao.ClienteDAO;
import py.edu.facitec.springtaller.model.Cliente;
//Gestionar transaciones
@Transactional

@Controller
public class ClienteController {
	
		@Autowired
		private ClienteDAO clienteDAO;
		
		@RequestMapping("/clientes")
		//Viene los datos del formulario y se pasa al objeto
		public String save(Cliente cliente){
			clienteDAO.guardar(cliente, cliente.getId());
			System.out.println("Registrado el cliente: "+cliente);
			return "/clientes/ok";
		}
		
		@RequestMapping("/clientes/formulario")
		public String formulario(){
			return "/clientes/formulario";
		}
}
//Crear el metodo para acceder al formulario