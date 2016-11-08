package py.edu.facitec.springtaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UtilidadController {
	@RequestMapping("/comollegar")
	public String index(){
		return "comollegar";
	}
}
