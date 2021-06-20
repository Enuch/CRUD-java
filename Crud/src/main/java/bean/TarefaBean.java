package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.ResponsavelDAO;
import dao.TarefaDAO;
import domain.Responsavel;
import domain.Tarefa;
import lombok.Data;

@Named
@Data
@ViewScoped
public class TarefaBean implements Serializable {
	private Tarefa tarefa;
	
	private List<Responsavel> responsaveis;
	private List<Tarefa> tarefas;
	
	private TarefaDAO tarefaDAO;
	private ResponsavelDAO responsavelDAO;
	
	@PostConstruct
	public void iniciar() {
		responsavelDAO = new ResponsavelDAO();
		tarefaDAO = new TarefaDAO();
		
		tarefa = new Tarefa();
		
		listar();
		
	}
	
	public void salvar() {
		tarefa.setEstado("Em andamento");
		tarefaDAO.salvar(tarefa);
		
		tarefa = new Tarefa();
		
		listar();
		
		Messages.addGlobalInfo("tarefa cadastrada com sucesso");
	}
	
	public void selecionar(Tarefa tarefaSelecionada) {
		tarefa = tarefaSelecionada;
	}
	
	public void excluir() {
		tarefaDAO.excluir(tarefa.getCodigo());
		
		tarefa = new Tarefa();
		listar();
		
		Messages.addGlobalInfo("tarefa excluida com sucesso");
	}
	
	public void editar() {
		tarefaDAO.editar(tarefa);
		
		tarefa = new Tarefa();
		
		listar();
		
		Messages.addGlobalInfo("tarefa editada com sucesso");
	}
	
	public void concluir() {
		tarefa.setEstado("Concluida");
		tarefaDAO.editar(tarefa);
		
		tarefa = new Tarefa();
		
		listar();
		
		Messages.addGlobalInfo("tarefa editada com sucesso");
	}
	
	public void listar() {
		tarefas = tarefaDAO.listar();
		responsaveis = responsavelDAO.listar();
	}
	
	public void listarSituacao() {
		tarefas = tarefaDAO.listarSituacao("Em andamento");
		
	}
}
