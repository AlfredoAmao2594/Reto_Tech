package com.reto.tech.springboot.app.Service;

import java.util.List;

import com.reto.tech.springboot.app.Bean.Requestkpideclientes;
import com.reto.tech.springboot.app.Model.Cliente;

public interface ClienteService {

	public Cliente add(Cliente cliente);
	public List<Cliente> listado();
	public Requestkpideclientes getDetail();
}
