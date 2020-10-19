package com.comviva.ConfigurationApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.ConfigurationApp.dao.ExportImportDao;
import com.comviva.ConfigurationApp.model.UseCase;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExportImportService {
	
	@Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
 
	
	@Autowired
	private  ExportImportDao exportImportDao;

	public UseCase exportUseCase(int id) {
		
		
		return exportImportDao.exportUseCase(id);
	}


	 
	
}
