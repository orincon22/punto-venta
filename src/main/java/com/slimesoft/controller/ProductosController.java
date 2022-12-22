package com.slimesoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.slimesoft.model.Producto;
import com.slimesoft.service.IProductosService;


@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	private IProductosService productosService;
	
	@GetMapping(value = "/agregar")
	public String agregarProducto(Model model) {
		Producto producto = new Producto();
	    model.addAttribute("producto", producto);
	    return "productos/agregar_producto";
	}
	
	
	@PostMapping(value = "/agregar")
	public String guardarProducto(@ModelAttribute Producto producto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
	    if (bindingResult.hasErrors()) {
	        return "productos/agregar_producto";
	    }
	    if (productosService.findFirstByCodigo(producto.getCodigo()) != null) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "Ya existe un producto con ese código")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/productos/agregar";
	    }
	    productosService.guardar(producto);
	    redirectAttrs
	            .addFlashAttribute("mensaje", "Agregado correctamente")
	            .addFlashAttribute("clase", "success");
	    return "redirect:/productos/agregar";
	}
}
