package user.search.image.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	private static String namespace = "user.search.image.";
	
}
