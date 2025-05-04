package bean;

import javax.faces.bean.ManagedBean;

import entidades.ArCondicionado;

@ManagedBean
public class ArCondicionadoBean {

	private ArCondicionado arCondicionado = new ArCondicionado();

	public ArCondicionado getArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(ArCondicionado arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
}
