package user.search.kin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.search.kin.service.KinService;

@Service
public class KinServiceImpl implements KinService {

	@Autowired
	private KinDAO dao;
	
}
