package user.search.webkr.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WebkrDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	private static String namespace = "user.search.webkr.";
	
}
