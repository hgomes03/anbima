package br.com.anbima.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ConfigConexao {
	
	
	public ConfigConexao() {
		
	}
	
	
	
	public JSONArray loadDB() throws ParseException, FileNotFoundException, IOException {
		
		String path = "C:\\projetosAnbima\\workspaceApi\\ESTIMATIVA_SELIC.JSON";
		
		JSONParser parser = new JSONParser();
		
		JSONArray jsonObject = (JSONArray) parser.parse(new FileReader(path));
		
		return jsonObject;
	}

}
