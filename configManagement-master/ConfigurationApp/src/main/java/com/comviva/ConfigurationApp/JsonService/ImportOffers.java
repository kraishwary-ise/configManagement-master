package com.comviva.ConfigurationApp.JsonService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.comviva.ConfigurationApp.ConfigurationAppApplication;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.OfferDrag;

public class ImportOffers {

    private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);

	public OfferDrag[] importOffers(int useCaseId) {
		
		
		List<OfferDrag> sendOffer = new ArrayList<OfferDrag>();
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
					
					JSONArray offers = (JSONArray)jsonObject.get("offers");
					
					if(offers==null) {
						return null;
					}
					else if(offers.size()==0) {
						logger.info("offer size is zero");
					}
					else {
					

					for(int i=0;i<offers.size();i++) {
						
					
					JSONObject offer1 = (JSONObject)offers.get(i);
					
					String offerName = (String) offer1.get("offerName");
					
					sendOffer.add(new OfferDrag(useCaseId,offerName));
					
					}
					
				}
					
		    	} catch (FileNotFoundException e) {
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
	
		    }
		}
			
		OfferDrag[] arrayOffer = sendOffer.toArray(new OfferDrag[sendOffer.size()]);
		
		
		return arrayOffer;
		
}

		
	}


