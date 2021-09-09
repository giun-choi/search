package user.search.blog.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	private static String namespace = "user.search.blog.";
	
}
