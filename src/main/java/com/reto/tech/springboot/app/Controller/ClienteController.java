package com.reto.tech.springboot.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tech.springboot.app.Bean.Requestkpideclientes;
import com.reto.tech.springboot.app.Model.Cliente;
import com.reto.tech.springboot.app.Service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping("/creacliente")
	public ResponseEntity<Cliente> add(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteService.add(cliente), HttpStatus.CREATED);
	}
	
	@GetMapping("/listclientes")
	public ResponseEntity<List<Cliente>> listado(){
		return new ResponseEntity<>(clienteService.listado(),HttpStatus.OK);
	}
	
	@GetMapping("/kpideclientes")
	public ResponseEntity<Requestkpideclientes> getDetail(){
		return new ResponseEntity<>(clienteService.getDetail(),HttpStatus.OK);
	}
}
