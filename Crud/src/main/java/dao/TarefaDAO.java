package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Tarefa;
import util.JPAUtil;

public class TarefaDAO {
	public void salvar(Tarefa tarefa) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(tarefa);
		transacao.commit();
		sessao.clear();	
	}
	
	public Tarefa buscar(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Tarefa tarefa = sessao.find(Tarefa.class, codigo);
		return tarefa;
	}
	
	public List<Tarefa> listar() {
		String jpql = "select t from Tarefa t order by titulo";
		
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Tarefa> resultado = consulta.getResultList();
		return resultado;
	}
	
	public List<Tarefa> listarSituacao(String estado) {
		String jpql = "select t from Tarefa t where t.estado =:estado";
		
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		consulta.setParameter("estado", estado);
		List<Tarefa> resultado = consulta.getResultList();
		return resultado;
	}
	
	public void excluir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		Tarefa tarefa = sessao.find(Tarefa.class, codigo);
		sessao.remove(tarefa);
		transacao.commit();
		sessao.close();
	}
	
	public void editar(Tarefa tarefa) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(tarefa);
		transacao.commit();
		sessao.close();
	}
	
	public void concluir(Tarefa tarefa) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(tarefa);
		transacao.commit();
		sessao.close();
	}
	
}
