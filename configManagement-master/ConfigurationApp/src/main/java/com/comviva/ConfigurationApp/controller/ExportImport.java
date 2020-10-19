package com.comviva.ConfigurationApp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.comviva.ConfigurationApp.ConfigurationAppApplication;
import com.comviva.ConfigurationApp.JsonService.DeleteJsonFile;
import com.comviva.ConfigurationApp.JsonService.ExportJsonService;
import com.comviva.ConfigurationApp.JsonService.ImportOffers;
import com.comviva.ConfigurationApp.JsonService.ImportSelection;
import com.comviva.ConfigurationApp.JsonService.ImportTrigger;
import com.comviva.ConfigurationApp.JsonService.ImportUseCase;
import com.comviva.ConfigurationApp.model.Trigger;
//
//import com.comviva.ConfigurationApp.JsonService.DeleteJsonFile;
//import com.comviva.ConfigurationApp.JsonService.ExportJsonService;
//import com.comviva.ConfigurationApp.JsonService.ImportUseCase;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.OfferDrag;
import com.comviva.ConfigurationApp.response.SelectionDrag;
import com.comviva.ConfigurationApp.response.TriggerDrag;
import com.comviva.ConfigurationApp.service.ExportImportService;
import com.comviva.ConfigurationApp.service.OfferService;
import com.comviva.ConfigurationApp.service.SelectionService;
import com.comviva.ConfigurationApp.service.TriggerService;
import com.comviva.ConfigurationApp.service.UseCaseService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class ExportImport {

	public static String uploadDir = System.getProperty("user.dir") + "/uploads";
	private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);

	@Autowired
	private ExportImportService exportImport;

	@Autowired
	private UseCaseService useCaseService;

	@Autowired
	private TriggerService triggerService;

	@Autowired
	private OfferService offerService;

	@Autowired
	private SelectionService selectionService;

	@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping("/Export")
	public void exportUseCase(@RequestBody int id) {

		logger.debug("in Export Controller");

		UseCase useCase = exportImport.exportUseCase(id);

		ExportJsonService exportJsonService = new ExportJsonService();

		exportJsonService.exportJsonService(useCase);
	}

	@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping("/importUseCase")
	public void importUseCase(@RequestParam("file") MultipartFile[] files) {

		logger.debug("in import use Case Controller");

		File mkfile = new File(uploadDir);			//Creating object to handle file
											
		boolean bool = mkfile.mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {

			Path fileNameAndPath = Paths.get(uploadDir, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename());		
			try {
				Files.write(fileNameAndPath, file.getBytes());		//writing json data to file
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//use try and cache for file handling operations
		ImportUseCase importUseCase = new ImportUseCase();

		List<UseCase> usecases = importUseCase.readAllFile();		

		for (UseCase u : usecases) {

			useCaseService.saveUseCase(u);

			int useCaseId = useCaseService.fetchIdByName(u.getName());

			ImportTrigger importTrigger = new ImportTrigger();

			TriggerDrag ArrayTrigger[] = importTrigger.importTrigger(useCaseId);

			ImportOffers importOffers = new ImportOffers();

			OfferDrag ArrayOffer[] = importOffers.importOffers(useCaseId);

			ImportSelection importSelection = new ImportSelection();

			SelectionDrag ArraySelection[] = importSelection.importSelection(useCaseId);
			
			/*creating subsquent array of triggers and their corresponding array objects*/

			if (ArrayTrigger != null) {
				logger.info("Trigger in Imported Json holding value");

				triggerService.saveTrigger(ArrayTrigger);
				logger.debug("save triggered");

			}
			if (ArrayOffer != null) {

				logger.info("Offer in Imported Json holding value");

				offerService.saveOffer(ArrayOffer);
logger.debug("save trggered");
			}

			if (ArraySelection != null) {
				logger.info("Selection in Imported Json holding value");
				selectionService.saveSelection(ArraySelection);
				logger.debug("save trggered");
				
			}

		}

	}
}
