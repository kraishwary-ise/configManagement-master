package com.comviva.ConfigurationApp.dao;

import java.util.List;

import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.StringResponse;
import com.comviva.ConfigurationApp.response.UseCaseResponse;

public interface UseCaseDao {
	
	
	
	public StringResponse saveUseCase(UseCase useCases);

	public List<UseCaseResponse> getUseCase();

	public void deleteUseCase(int id);

	public int fetchIdByName(String name);
	
}
