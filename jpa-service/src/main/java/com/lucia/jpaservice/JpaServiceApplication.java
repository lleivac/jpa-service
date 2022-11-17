package com.lucia.jpaservice;

import com.lucia.jpaservice.repository.ClienteRepository;
import com.lucia.jpaservice.repository.DetalleVentasRepository;
import com.lucia.jpaservice.repository.ProductoRepository;
import com.lucia.jpaservice.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaServiceApplication implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DetalleVentasRepository detalleVentasRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	VentaRepository ventaRepository;

	public static void main(String[] args) { SpringApplication.run(JpaServiceApplication.class, args); }

	@Override
	public void run(String...args) throws Exception{
		
	}
	}
