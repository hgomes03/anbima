package br.com.anbima.backend.infraestrutura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.context.annotation.Configuration;

import br.com.anbima.backend.entity.Selic;

@Configuration
public class ConfigMemEstrutura {
	
	//Ano
	private static Map<String, List<Selic>> mapAnoSelic = new HashMap<String, List<Selic>>();
	
	//Ano:Mes
	private static Map<String, List<Selic>> mapAnoMesSelic = new HashMap<String, List<Selic>>();
	
	/**
	*	Gerando uma estrutura para que o db funcione como
	*   se existissem indices 
	*   Ja que não existe requesito que pede para escrever no banco. 
	*/
	public void loadInit() {
		
		String path = "C:\\projetosAnbima\\workspaceApi\\ESTIMATIVA_SELIC.JSON";
		
		
        //Cria o parse de tratamento
        try {
			JSONParser parser = new JSONParser(new FileReader(new File(path)));
			
			for (Object jp:parser.list()) {
				
				LinkedHashMap linked = (LinkedHashMap)jp;
				
				Selic selic = new Selic();
				selic.setData((String)linked.get("data_referencia"));
				
				BigDecimal number = (BigDecimal)linked.get("estimativa_taxa_selic");
				selic.setEstimativaTaxa(number.doubleValue());
				
				configEstrutura(selic);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
    
	private void configEstrutura(Selic selic) {
	
		String ano = selic.getData().substring(0,4);
		String mes = selic.getData().substring(5,7);
		
		configEstrutura(ano, selic);
		configEstrutura(ano, mes, selic);
	}
	
	private void configEstrutura(String ano, Selic selic) {
		
		List<Selic> selicsPorAno = mapAnoSelic.get(ano);
		
		if (selicsPorAno==null) {
			selicsPorAno = new ArrayList<Selic>();
			mapAnoSelic.put(ano, selicsPorAno);
		}
		
		selicsPorAno.add(selic);
	}
	
	private void configEstrutura(String ano, String mes, Selic selic) {
		
		String chave = ano + ":" + mes;
		List<Selic> selicsPorAnoMes = mapAnoMesSelic.get(chave);
		
		if (selicsPorAnoMes==null) {
			selicsPorAnoMes = new ArrayList<Selic>();
			mapAnoMesSelic.put(chave, selicsPorAnoMes);
		}
		
		selicsPorAnoMes.add(selic);
	}

	public static Map<String, List<Selic>> getMapAnoSelic() {
		return mapAnoSelic;
	}

	public static Map<String, List<Selic>> getMapAnoMesSelic() {
		return mapAnoMesSelic;
	}
}