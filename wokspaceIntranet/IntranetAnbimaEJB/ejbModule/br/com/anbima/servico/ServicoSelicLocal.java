package br.com.anbima.servico;

import java.util.List;

import javax.ejb.Local;

import br.com.anbima.entities.Selic;

@Local
public interface ServicoSelicLocal {
	
	public List<Selic> getAll() throws Exception;

}
