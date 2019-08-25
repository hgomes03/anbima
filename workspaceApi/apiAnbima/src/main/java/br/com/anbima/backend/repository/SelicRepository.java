package br.com.anbima.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.anbima.backend.entity.Selic;
import br.com.anbima.backend.infraestrutura.ConfigMemEstrutura;

@Repository
public class SelicRepository {
	
	@Autowired
	private ConfigMemEstrutura configDB;
	
	public List<Selic> findByAno(String ano) {

		List<Selic> selics = configDB.getMapAnoSelic().get(ano);
		
		if (selics!=null && !selics.isEmpty()) {
			return selics;
		} else {
			return new ArrayList<Selic>();
		}
	}
	
	public List<Selic> findByAnoMes(String ano, String mes) {
		
		String key = ano + ":" + mes;
		List<Selic> selics = configDB.getMapAnoMesSelic().get(key);
		
		if (selics!=null && !selics.isEmpty()) {
			return selics;
		} else {
			return new ArrayList<Selic>();
		}
	}
}
