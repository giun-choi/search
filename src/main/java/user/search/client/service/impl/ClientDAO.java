package user.search.client.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import user.search.client.service.ClientVO;

@Repository
public class ClientDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	private static String namespace = "user.search.client.";
	
	public int setSearchWord(ClientVO clientVO) throws Exception {
		
		return session.insert(namespace + "setSearchWord", clientVO);
	}
	
	public int setClickLink(ClientVO clientVO) throws Exception {
		
		return session.insert(namespace + "setClickLink", clientVO);
	}
	
}
