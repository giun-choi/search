package user.search.doc.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DocDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	private static String namespace = "user.search.doc.";
	
}
