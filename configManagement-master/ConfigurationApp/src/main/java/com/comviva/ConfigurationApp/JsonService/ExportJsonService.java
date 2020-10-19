package com.comviva.ConfigurationApp.JsonService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Date;

import com.comviva.ConfigurationApp.ConfigurationAppApplication;
import com.comviva.ConfigurationApp.model.Offer;
import com.comviva.ConfigurationApp.model.Selection;
import com.comviva.ConfigurationApp.model.Trigger;
import com.comviva.ConfigurationApp.model.UseCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ExportJsonService {

    private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);


	
	public void exportJsonService(UseCase useCase){
		JSONObject jsonData=new JSONObject();

		
		JSONArray list = new JSONArray();

		JSONArray offerList = new JSONArray();
		
		JSONArray selectionList = new JSONArray();


		
		int id = useCase.getId();
		
		jsonData.put("id", id);
		
		String name = useCase.getName();
		
		jsonData.put("name", name);
		
		String Desc = useCase.getDesc();
		
		jsonData.put("description", Desc);
		
		
		Date sdate = useCase.getSdate();
		

		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		String sDate = dateFormat.format(sdate);  
		

		jsonData.put("sDate", sDate);
		
		
		Date edate = useCase.getEdate();
		
		
		String eDate = dateFormat.format(edate);  
		
		jsonData.put("eDate", eDate);

		
		logger.debug("print end date",edate);

		
		String direction = useCase.getDirection();
		
		jsonData.put("direction", direction);
		
		
		String campeing = useCase.getCampeing();
		
		jsonData.put("campeing", campeing);
		
		String businesslog = useCase.getBusinesslog();
		
		jsonData.put("businessLog", businesslog);
		
		List<Trigger> triggers = new ArrayList<Trigger>();
		
		List<Offer> offers = new ArrayList<Offer>();
		
		List<Selection> selection = new ArrayList<Selection>();

		
		
		if(useCase.getTriggers().isEmpty()) {
			
			logger.error("null");
		
		}
		
	
			else {
				
				logger.debug("correct else");
				
				logger.info("size= "+useCase.getTriggers().size());
				
				for(int i=0;i<useCase.getTriggers().size();i++) {
					
					int triggerId = useCase.getTriggers().get(i).getId();
					
					logger.debug("Importing Trigger id" + triggerId);
					
					String triggerName = useCase.getTriggers().get(i).getTriggerName();
					
					int useCaseId = useCase.getId();
					
					JSONObject trigger=new JSONObject();

					
					trigger.put("triggerId", triggerId);
					
					trigger.put("triggerName", triggerName);
					
					trigger.put("useCaseId",useCaseId);
					
					list.add(trigger);

					
				}
				
		
			
				jsonData.put("triggers", list);

	}
		
		
		

		if(useCase.getOffers().isEmpty()) {
			
			logger.info("null");
		
		}
		

			else {
				
				logger.info("correct else");
				
				logger.info(useCase.getOffers().size());
				
				for(int i=0;i<useCase.getOffers().size();i++) {
					
					int offerId = useCase.getOffers().get(i).getId();
					
					logger.info("Trigger id" + offerId);
					
					String offerName = useCase.getOffers().get(i).getOfferName();
					
					int useCaseId = useCase.getId();
					
					JSONObject offer=new JSONObject();

					
					offer.put("offerId", offerId);
					
					offer.put("offerName", offerName);
					
					offer.put("useCaseId",useCaseId);
					
					offerList.add(offer);

					
				}
				
		
			
				jsonData.put("offers", offerList);

	}
		
		

		

			if(useCase.getSelection().isEmpty()) {
			
			logger.info("null Value");
		
		}
			else {
				
			//	logger.info("correct else");
				
				logger.debug(useCase.getSelection().size());
				
				for(int i=0;i<useCase.getSelection().size();i++) {
					
					int selectionId = useCase.getSelection().get(i).getId();
					
					logger.info("print trigger id" + selectionId);
					
					String selectionName = useCase.getSelection().get(i).getSelectionName();
					
					int useCaseId = useCase.getId();
					
					JSONObject selections = new JSONObject();

					
					selections.put("selectionId", selectionId);
					
					selections.put("selectionName", selectionName);
					
					selections.put("useCaseId",useCaseId);
					
					selectionList.add(selections);					

					
				}
				
		
			
				jsonData.put("selectionMethod", selectionList);

	}
		
		

		
		
		
		 String path;
		
		
		path="D:\\SeleniumSoftware\\configManagement-master\\configManagement-master\\ConfigurationApp\\UseCases";
		
		
		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		
		Date dateobj = new Date(); 
		
		String strDate = df.format(dateobj);
		
		File file = new File(path);
		String filename="Uc_"+name+"_"+strDate + ".json";

		String fullFileName=path+"\\"+filename;
		
		boolean fileExists=file.exists();
		
		//TRY ND CACHE
		if(!fileExists) {
		      boolean bool = file.mkdir();

		}
		try {
	        	BufferedWriter out = new BufferedWriter(new FileWriter(fullFileName));
	        	
	        	logger.info("File Name"+fullFileName);
	            out.append(jsonData.toJSONString());
	            out.close();
	            
	        }
	        	
	        	
	        	
	        	catch (IOException e) {
	         //e.printStackTrace();
	            logger.error("writing problem");
	        }
	
	
	}
	
}
