package dao;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import domain.Tarefa;

@FixMethodOrder(MethodSorters.JVM)
public class TarefaDAOTest {
	private TarefaDAO tarefaDAO;
	
	@Before
	public void inciar() {
		tarefaDAO = new TarefaDAO();
	}
	
	public void salvar() {
		Tarefa t1 = new Tarefa();
		Tarefa t2 = new Tarefa();
		
		t1.setTitulo("Jogas DS2");
		t1.setDescricao("Matar 3 bosses e ir na ancient bonfire");
		t1.setPrioridade("Alta");
		t1.setDeadline(LocalDate.of(2021, 12, 10));
		
		t2.setTitulo("Jogas GTA 5");
		t2.setDescricao("Zerar");
		t2.setPrioridade("Média");
		t2.setDeadline(LocalDate.of(2021, 12, 10));
		
		tarefaDAO.salvar(t1);
		tarefaDAO.salvar(t2);
	}
	
	public void buscar() {
		Tarefa t1 = tarefaDAO.buscar(1);
		
		System.out.println(t1);
	}
	
	public void listar() {
		List<Tarefa> tarefas = tarefaDAO.listar();
		
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
	}
	
	@Test
	public void testar() {
		salvar();
		buscar();
		listar();
	}
}
