package br.com.catalogoprodutos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.catalogoprodutos.dao.CategoriaDAO;
import br.com.catalogoprodutos.dao.ProdutoDAO;
import br.com.catalogoprodutos.model.Categoria;
import br.com.catalogoprodutos.model.Produto;

@Controller
public class ProdutoController {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	ProdutoDAO produtoDao;
	
	@Autowired
	CategoriaDAO categoriaDAO;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/produtos")
	public String produtos(Model model) {
		List<Produto> produtos = produtoDao.getProdutosWithCategoria();

		model.addAttribute("produtos", produtos);

		return "produtos";
	}
	
	@RequestMapping("/novoproduto")
	public String novoproduto(Model model){
		
		List<Categoria> categorias = categoriaDAO.getCategorias();
		
		model.addAttribute("categorias", categorias);
	
		return "cadastroproduto";
	}
	
	@RequestMapping("/cadastraproduto")
	public String cadastraproduto(@RequestParam("nome") String nome, @RequestParam("preco") Double preco, 
			@RequestParam("categoria") long categoria){
		
		Categoria c = this.entityManager.find(Categoria.class, categoria);
		Produto p = new Produto();
		p.setNome(nome);
		p.setPreco(preco);
		p.setCategoria(c);
		
		produtoDao.newProduto(p);
		
		return "redirect:produtos";
	
	}
	

	@ResponseBody
	@RequestMapping("/produtoJSON")
	public String produtoJSON() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		Produto p = new Produto();
		p.setNome("Kansas - The Best Of");
		p.setPreco(20.00);

		String produtoJSON = gson.toJson(p);

		return produtoJSON;

	}

}
