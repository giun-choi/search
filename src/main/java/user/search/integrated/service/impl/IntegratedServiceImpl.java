package user.search.integrated.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.search.integrated.service.IntegratedService;

@Service
public class IntegratedServiceImpl implements IntegratedService {

	@Autowired
	private IntegratedDAO dao;
	
}
