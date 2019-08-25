package br.com.anbima.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;

import br.com.anbima.entities.Selic;
import br.com.anbima.util.ConfigConexao;

public class SelicDao {
	
	public List<Selic> getAll() throws IOException, FileNotFoundException, IOException, ParseException {
		
		List<Selic> selics = new ArrayList<Selic>();
		
		ConfigConexao config = new ConfigConexao();
		JSONArray jsonArray  = config.loadDB();
		Iterator<Object> ita = jsonArray.iterator();
		
		while(ita.hasNext()) {
			
			Object object = ita.next();
			
			ModelMapper modelMapper = new ModelMapper();
		 	Selic selic = modelMapper.map(object, Selic.class);   
			
			if (selic!=null) {
				selics.add(selic);
			}
		}
		
		return selics;
		
	}

}
