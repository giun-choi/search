package user.search.cafearticle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.search.cafearticle.service.CafearticleService;

@Service
public class CafearticleServiceImpl implements CafearticleService {

	@Autowired
	private CafearticleDAO dao;
	
}
