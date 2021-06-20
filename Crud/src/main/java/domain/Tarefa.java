package domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Generated;

import lombok.Data;

@Entity
@Data
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(length = 50, nullable = false, unique = true)
	private String titulo;
	
	@Column
	private String descricao;
	
	@Column(length = 10, nullable = false)
	private String prioridade;
	
	@Column(nullable = false)
	private LocalDate deadline;
	
	@Column
	private String estado;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Responsavel responsavel;
}
