package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Responsavel;
import util.JPAUtil;

public class ResponsavelDAO {
	public void salvar(Responsavel responsavel) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(responsavel);
		transacao.commit();
		sessao.clear();	
	}
	
	public Responsavel buscar(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Responsavel responsavel = sessao.find(Responsavel.class, codigo);
		return responsavel;
	}
	
	public List<Responsavel> listar() {
		String jpql = "select c from Responsavel c order by nome";
		
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Responsavel> resultado = consulta.getResultList();
		return resultado;
	}
}
