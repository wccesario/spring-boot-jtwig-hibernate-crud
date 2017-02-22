package br.com.catalogoprodutos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.catalogoprodutos.model.Categoria;

@Repository
@Transactional
public class CategoriaDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Categoria> getCategorias(){
		
		List<Categoria> categorias = this.entityManager.createQuery("select c from categoria c").getResultList();

		return categorias;
		
	}
	
	public void newCategoria(Categoria categoria){
		this.entityManager.persist(categoria);
	}
	
}
