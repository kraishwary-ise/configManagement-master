package com.comviva.ConfigurationApp.JsonService;

import java.io.File;

public class DeleteJsonFile {
	
	
	public void deleteFolder(File file) {
		
		
	      
	      for (File subFile : file.listFiles()) {
	          if(subFile.isDirectory()) {
	             deleteFolder(subFile);
	          } else {
	             subFile.delete();
	          }
	       }
	       file.delete();

	}

}
