package com.reto.tech.springboot.app.Service.Imple;

import java.util.Iterator;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.tech.springboot.app.Bean.Requestkpideclientes;
import com.reto.tech.springboot.app.Model.Cliente;
import com.reto.tech.springboot.app.Repository.ClienteRepository;
import com.reto.tech.springboot.app.Service.ClienteService;

@Service
public class ClienteServiceImple implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente add(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			return clienteRepository.save(cliente);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServiceException("Error al registrar al cliente ",e);
		}
		
	}

	@Override
	public List<Cliente> listado() {
		// TODO Auto-generated method stub	
		try {
			return clienteRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServiceException("Error al listar clientes ",e);
		}
	}

	@Override
	public Requestkpideclientes getDetail() {
		// TODO Auto-generated method stub
		
		try {
			Requestkpideclientes kpi = new Requestkpideclientes();
			List<Cliente> listado = listado();
			System.out.println(listado);
			
			if(listado.isEmpty()) {
				kpi.setDesviacion(0.00);
				kpi.setPromedio(0.00);
				kpi.setMensaje("No hay clientes en la lista. Agregue clientes para calcular KPI.");
			}else {

				if(listado.size() > 1 ){
					Double suma = 0.0;
					for (Cliente cliente : listado) {
						 suma += cliente.getEdad();
					}
					Double prom = suma / listado.size();
					
					Double totalEdades = 0.0;
					
					for (Cliente cliente : listado) {
						Double diferencia = cliente.getEdad() - prom;
						Double potencia = Math.pow(diferencia, 2);
						totalEdades += potencia;
					}
					
					Double desviacion = Math.sqrt(totalEdades/(listado.size()-1));
					
					kpi.setPromedio(prom);
					kpi.setDesviacion(desviacion);
					
				}else {
					kpi.setDesviacion(0.00);
					kpi.setPromedio(0.00);
					kpi.setMensaje("Datos insuficientes. Debe agregar al menos 2 clientes para calcular la desviación estándar.");
				}

			}
			return kpi;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServiceException("Error al calcular los KPI de clientes",e);
		}
		
		
	}

}
