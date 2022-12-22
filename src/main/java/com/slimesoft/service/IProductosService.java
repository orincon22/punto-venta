package com.slimesoft.service;

import java.util.List;

import com.slimesoft.model.Producto;

public interface IProductosService {

	List<Producto> buscarTodos();
	Producto findFirstByCodigo(String codigo);
	void guardar(Producto producto);
}
