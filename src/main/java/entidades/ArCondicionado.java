package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ArCondicionado {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Date dataManutencao;
	@Column(nullable = false)
	private Integer temperaturaAtual;
	@Column(nullable = false)
	private Integer temperaturaMinima;
	@Column(nullable = false)
	private Integer temperaturaMaxima;

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

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
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
