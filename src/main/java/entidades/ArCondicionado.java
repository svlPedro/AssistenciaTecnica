package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class ArCondicionado {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String descricao;
	private LocalDate dataManutencao;
	@Column(nullable = false)
	private Integer temperaturaAtual;
	@Column(nullable = false)
	private Integer temperaturaMinima;
	@Column(nullable = false)
	private Integer temperaturaMaxima;

	public void validacoes() {
		validarData();
		validarTemperaturaMinima();
		validarTemperaturaMaxima();
	}
	
	public void validarEdit() {
		validarTemperaturaMinima();
		validarTemperaturaMaxima();
	}
	
	public LocalDate validarData() {
		LocalDate cadastro = LocalDate.now();
		
		if(dataManutencao.isBefore(cadastro)) {
			  FacesContext.getCurrentInstance().addMessage(null,
			  new FacesMessage(FacesMessage.SEVERITY_ERROR, "A data de Manutenção deve ser superior a data de cadastro.", null));
			  return null;
		}
		return dataManutencao;
	}
	
	public Integer validarTemperaturaMinima() {
		if(temperaturaMinima < 10 || temperaturaMinima > 16) {
			  FacesContext.getCurrentInstance().addMessage(null,
			  new FacesMessage(FacesMessage.SEVERITY_ERROR, "A temperatura Mínima deve estar entre 10 e 16", null));
			  return null;
		}
		return temperaturaMinima;
	}
	
	public Integer validarTemperaturaMaxima() {
		if(temperaturaMaxima < 20 || temperaturaMaxima > 25) {
			  FacesContext.getCurrentInstance().addMessage(null,
			  new FacesMessage(FacesMessage.SEVERITY_ERROR, "A temperatura Máxima deve estar entre 20 e 25", null));
			  return null;
		}
		return temperaturaMaxima;
	}
	
	public String getDataFormatada() {
	    if (dataManutencao == null) {
	        return "";
	    }
	    return dataManutencao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(LocalDate dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Integer getTemperaturaAtual() {
		return temperaturaAtual;
	}

	public void setTemperaturaAtual(Integer temperaturaAtual) {
		this.temperaturaAtual = temperaturaAtual;
	}

	public Integer getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(Integer temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public Integer getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(Integer temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}
}