package com.slimesoft.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.slimesoft.model.Producto;

@Service
public class ProductosServiceImpl implements IProductosService {
	
	List<Producto> lista;
	
	public ProductosServiceImpl() {
		lista = new LinkedList<>();
		
		Producto producto1 = new Producto();
		producto1.setId(1);
		producto1.setNombre("Olla presurizada");
		producto1.setCodigo("12345687891");
		producto1.setExistencia(10.0f);
		producto1.setPrecio(125.00f);
		
		Producto producto2 = new Producto();
		producto2.setId(2);
		producto2.setNombre("Vaso de cristal");
		producto2.setCodigo("1223456789");
		producto2.setExistencia(230f);
		producto2.setPrecio(175f);
		
		Producto producto3 = new Producto();
		producto3.setId(3);
		producto3.setNombre("Computadora gamer");
		producto3.setCodigo("123");
		producto3.setExistencia(4.0f);
		producto3.setPrecio(8699.35f);
		
		
		lista.add(producto1);
		lista.add(producto2);
		lista.add(producto3);
		
	}

	@Override
	public List<Producto> buscarTodos() {
		return lista;
	}

	@Override
	public Producto findFirstByCodigo(String codigo) {
		for(Producto p : lista) {
			if(p.getCodigo().equals(codigo)) {
				return p;
			}
			
			System.out.println("*"+ codigo + "* *"+ p.getCodigo()+"*");
		}
		return null;
	}

	@Override
	public void guardar(Producto producto) {
		lista.add(producto);
		for(Producto p : lista) {
			System.out.println(p);
		}
		System.out.println("Se guardo producto: " + producto);
	}

}
