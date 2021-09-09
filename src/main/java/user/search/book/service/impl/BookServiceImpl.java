package user.search.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.search.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO dao;
	
}
