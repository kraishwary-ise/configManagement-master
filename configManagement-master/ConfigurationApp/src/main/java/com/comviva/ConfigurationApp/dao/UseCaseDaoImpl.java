package com.comviva.ConfigurationApp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.model.User;
import com.comviva.ConfigurationApp.response.StringResponse;
import com.comviva.ConfigurationApp.response.UseCaseResponse;

@Repository
public class UseCaseDaoImpl implements UseCaseDao {

	private EntityManager entityManager;

	@Autowired
	public UseCaseDaoImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;

	}

	@Override
	@Transactional
	public StringResponse saveUseCase(UseCase useCase) {
		int name_length = useCase.getName().length();
		int desc_length = useCase.getDesc().length();
		Session currentSession = entityManager.unwrap(Session.class);

		String hql = "from UseCase u where u.name=:name";

		Query query = currentSession.createQuery(hql);

		query.setParameter("name", useCase.getName());

		List<UseCase> results = query.getResultList();

		StringResponse response = new StringResponse();

		if (name_length < 45 && desc_length < 45) {

			if (results.isEmpty()) {
				currentSession.saveOrUpdate(useCase);

				String hql1 = "from UseCase u where u.name=:name";

				Query query1 = currentSession.createQuery(hql);

				query.setParameter("name", useCase.getName());

				List<UseCase> results1 = query.getResultList();

				int id = results1.get(0).getId();

				response.setId(id);

				response.setResponse("Use Case Submit Successfully");

				return response;

			}
			response.setId(0);

			response.setResponse("UseCase Already Exists Please try again with different name");

			return response;

		} else {
			response.setResponse("Name and Description Should be less than 45 characters");
			
			return response;
		}
	}

	@Override
	@Transactional

	public List<UseCaseResponse> getUseCase() {

		Session currentSession = entityManager.unwrap(Session.class);

		String hql = "from UseCase uc";

		Query query = currentSession.createQuery(hql);

		List<UseCase> results = query.getResultList();
		List<UseCaseResponse> useCaseResponse = new ArrayList<UseCaseResponse>();

		for (int i = 0; i < results.size(); i++) {

			int id = results.get(i).getId();
			String name = results.get(i).getName();
			String desc = results.get(i).getDesc();
			String Type = "Standard";
			Date sdate = results.get(i).getSdate();
			Date edate = results.get(i).getEdate();
			String status = "NA";
			String env = "Development";

			useCaseResponse.add(new UseCaseResponse(id, name, desc, Type, sdate, edate, status, env));

		}

		return useCaseResponse;

	}

	@Override
	@Transactional

	public void deleteUseCase(int id) {

		Session currentSession = entityManager.unwrap(Session.class);

		String hql = "delete from UseCase where id=:id";

		Query query = currentSession.createQuery(hql);

		query.setParameter("id", id);

		query.executeUpdate();

	}

	@Override
	@Transactional

	public int fetchIdByName(String name) {

		Session currentSession = entityManager.unwrap(Session.class);

		String hql = "from UseCase u where u.name=:name";

		Query query = currentSession.createQuery(hql);

		query.setParameter("name", name);

		List<UseCase> results1 = query.getResultList();

		if (results1.isEmpty()) {

			return 0;

		} else {

			int id = results1.get(0).getId();

			return id;

		}

	}

}
