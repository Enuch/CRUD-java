package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.ResponsavelDAO;
import domain.Responsavel;
import lombok.Data;

@Named
@Data
@ViewScoped
public class ResponsavelBean implements Serializable {
	private Responsavel responsavel;
	private List<Responsavel> responsaveis;
	
	private ResponsavelDAO responsavelDAO;
	
	@PostConstruct
	public void iniciar() {
		responsavelDAO = new ResponsavelDAO();
		
		responsavel = new Responsavel();
		listar();
	}
	
	public void salvar() {
		responsavelDAO.salvar(responsavel);
		
		responsavel = new Responsavel();
		listar();
		
		Messages.addGlobalInfo("Responsavel salva com sucesso");
	}
	
	public void listar() {
		responsaveis = responsavelDAO.listar();
	}
}
