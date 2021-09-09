package user.search.webkr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.search.webkr.service.WebkrService;

@Service
public class WebkrServiceImpl implements WebkrService {

	@Autowired
	private WebkrDAO dao;
	
}
