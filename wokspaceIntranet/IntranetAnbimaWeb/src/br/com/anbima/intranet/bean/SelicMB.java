package br.com.anbima.intranet.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.anbima.entities.Selic;
import br.com.anbima.servico.ServicoSelicLocal;

@ManagedBean
public class SelicMB {
	
	private boolean exibirFiltroHistorico;
	
	private List<Selic> selics;
	
	@EJB
	private ServicoSelicLocal servico;
	
	@PostConstruct
	public void init() {
		loadHistorico();
	}
	
	public void loadHistorico() {
		
		try {
			this.selics = this.servico.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isExibirFiltroHistorico() {
		return exibirFiltroHistorico;
	}

	public void setExibirFiltroHistorico(boolean exibirFiltroHistorico) {
		this.exibirFiltroHistorico = exibirFiltroHistorico;
	}

	public List<Selic> getSelics() {
		
		
		
		return selics;
	}

	public void setSelics(List<Selic> selics) {
		this.selics = selics;
	}

	
	
	
}
