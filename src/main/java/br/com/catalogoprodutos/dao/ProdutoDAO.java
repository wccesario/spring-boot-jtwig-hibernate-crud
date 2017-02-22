package br.com.catalogoprodutos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.catalogoprodutos.model.Produto;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Produto> getProdutosWithCategoria(){
		
		List<Produto> produtos = this.entityManager.createQuery("from produto p inner join fetch p.categoria").getResultList();

		return produtos;
		
	}
	
	public void newProduto(Produto p){
		
		
		this.entityManager.persist(p);
			
	}
	
}
