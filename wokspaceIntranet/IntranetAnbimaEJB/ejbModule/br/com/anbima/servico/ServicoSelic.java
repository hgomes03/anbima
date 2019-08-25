package br.com.anbima.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.anbima.dao.SelicDao;
import br.com.anbima.entities.Selic;

/**
 * Session Bean implementation class ServicoSelic
 */
@Stateless
public class ServicoSelic implements ServicoSelicLocal {

	
	private SelicDao dao = new SelicDao();
	
    /**
     * Default constructor. 
     */
    public ServicoSelic() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Selic> getAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
    
    

}