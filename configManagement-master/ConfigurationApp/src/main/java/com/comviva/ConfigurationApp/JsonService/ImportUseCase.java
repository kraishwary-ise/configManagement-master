package com.comviva.ConfigurationApp.JsonService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.comviva.ConfigurationApp.ConfigurationAppApplication;
import com.comviva.ConfigurationApp.model.Trigger;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.TriggerDrag;




public class ImportUseCase {
	
	private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);

	
	
	private String triggerName;
	
	
	

	public List<UseCase> readAllFile()  {
		
		String path="D:\\SeleniumSoftware\\configManagement-master\\configManagement-master\\ConfigurationApp\\uploads";
		
		File folder = new File(path);
		
		JSONParser parser = new JSONParser();
		
		List<UseCase> usecases = new ArrayList<UseCase>(); 
		
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
			
		    if (file.isFile()) {
		    	
		    	try {
					Object obj = parser.parse(new FileReader(file));
					JSONObject jsonObject = (JSONObject)obj;
					
					String name=(String) jsonObject.get("name");
					
					
					
					String descr=(String) jsonObject.get("description");
					
					
					logger.info("importing usecase "+name);
					logger.info("importing desc "+descr);
					
					
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String sdate = (String) jsonObject.get("sDate");
					
					Date sDate=null;
					if(sdate!=null) {
					sDate = formatter.parse(sdate);
					}
					logger.info("importing sDate " + sDate);
					
					String campeingObjective = (String) jsonObject.get("campeing");
					logger.info("importing campeig " + campeingObjective);
					
					
					String edate = (String) jsonObject.get("eDate");
					
					
					Date eDate = null;
					if(sdate!=null) {
					eDate = formatter.parse(edate);
					}
					logger.info("importing edate " + eDate);
					
					
					
					String businessGroup = (String) jsonObject.get("businessLog");
					logger.debug("importing bUSINESS GROUP" + businessGroup);
					String Direction = (String) jsonObject.get("direction");
					
					logger.debug("importing usecase dIRECTION"+Direction);
					
					usecases.add(new UseCase(name, descr, sDate, eDate,  Direction,campeingObjective,businessGroup));
	
					
					

					
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (java.text.ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    	
		    }
		}
		return usecases;

		
		
		
	}


	
	
}
