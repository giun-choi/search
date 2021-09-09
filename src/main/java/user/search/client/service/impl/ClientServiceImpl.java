package user.search.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.search.client.service.ClientService;
import user.search.client.service.ClientVO;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO dao;
	
	@Override
	public int setSearchWord(ClientVO clientVO) throws Exception {

		return dao.setSearchWord(clientVO);
	}

	@Override
	public int setClickLink(ClientVO clientVO) throws Exception {

		return dao.setClickLink(clientVO);
	}

}
