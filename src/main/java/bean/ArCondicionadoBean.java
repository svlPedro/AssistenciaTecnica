package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.ArCondicionadoDAO;
import entidades.ArCondicionado;

@ManagedBean
public class ArCondicionadoBean {

	private List<ArCondicionado> lista;
	private ArCondicionado arCondicionadoSelecionado = new ArCondicionado();
	private ArCondicionado arc = new ArCondicionado();
	
	public String salvar() {	
		arc.validacoes();
		
		if (FacesContext.getCurrentInstance().getMessageList().stream()
				.anyMatch(msg -> msg.getSeverity().equals(FacesMessage.SEVERITY_ERROR))) {
			return null; // Não prossegue com o cadastro caso haja alguma mensagem do tipo SEVERITY_ERROR
		}
		
		arc.setTemperaturaAtual(20);
		ArCondicionadoDAO.salvar(arc);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ar Condicionado Cadastrado com Sucesso!"));
		arc = new ArCondicionado();
		return null;
	}
	
	public String deletar() {
		lista.remove(arCondicionadoSelecionado);
	    ArCondicionadoDAO.deletar(arCondicionadoSelecionado);
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Id ["+arCondicionadoSelecionado.getId()+"] removido com Sucesso."));
	    return null;
	}	
	
	public void salvarEdicao(org.primefaces.event.RowEditEvent<ArCondicionado> event) {

		ArCondicionado arcEditado = event.getObject();
		
		arcEditado.validarEdit();
		
		if (FacesContext.getCurrentInstance().getMessageList().stream()
	        .anyMatch(msg -> msg.getSeverity().equals(FacesMessage.SEVERITY_ERROR))) {
	        FacesContext.getCurrentInstance().validationFailed(); // <- Se houver falha na validação, a edição é cancelada.
	        return;
	    }
	    
	    ArCondicionadoDAO.salvar(arcEditado);
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Edição realizada com sucesso!"));
	}

	public void cancelarEdicao(org.primefaces.event.RowEditEvent<ArCondicionado> event) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Edição cancelada."));
	}
	
	public String retornar() {
		return "index";
	}
	
	public List<ArCondicionado> getLista() {
		if (lista == null) {
			lista = ArCondicionadoDAO.listarTodos();
		}
		return lista;
	}

	public void setLista(List<ArCondicionado> lista) {
		this.lista = lista;
	}
	
	public ArCondicionado getArCondicionado() {
		return arc;
	}

	public ArCondicionado getArCondicionadoSelecionado() {
		return arCondicionadoSelecionado;
	}

	public void setArCondicionadoSelecionado(ArCondicionado arCondicionadoSelecionado) {
		this.arCondicionadoSelecionado = arCondicionadoSelecionado;
	}

	public ArCondicionado getArc() {
		return arc;
	}

	public void setArc(ArCondicionado arc) {
		this.arc = arc;
	}

	public void setArCondicionado(ArCondicionado arCondicionado) {
		this.arc= arCondicionado;
	}
}