package user.search.encyc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.search.encyc.service.EncycService;

@Service
public class EncycServiceImpl implements EncycService {

	@Autowired
	private EncycDAO dao;
	
}
