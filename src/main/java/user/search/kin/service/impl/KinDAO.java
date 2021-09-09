package user.search.kin.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KinDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	private static String namespace = "user.search.kin.";
	
}
