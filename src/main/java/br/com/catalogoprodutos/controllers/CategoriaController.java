package br.com.catalogoprodutos.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.catalogoprodutos.dao.CategoriaDAO;
import br.com.catalogoprodutos.model.Categoria;

@Controller
public class CategoriaController {

	@Autowired
	CategoriaDAO categoriaDAO;
	
	@ResponseBody
	@RequestMapping("/categoriaJSON")
	public String categoriaJSON(){
		List<Categoria> c = categoriaDAO.getCategorias();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String categorias = gson.toJson(c);
		
		return categorias;
	}
	
	@RequestMapping("/novacategoria")
	public String novacategoria(){
			
		return "cadastrocategoria";
	}
	
	@RequestMapping("/cadastracategoria")
	public String cadastracategoria(@RequestParam("nome") String nome) {
		
		Categoria c = new Categoria();
		c.setNome(nome);
		
		categoriaDAO.newCategoria(c);
		
		return "redirect:novacategoria";
		
	}
	
	
}
