package user.search.book.web;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import base.constant.Constant;
import base.utils.Naver;
import user.search.book.service.BookVO;
import user.search.book.service.BookService;

@Controller
@RequestMapping("/search")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/book")
	public ModelAndView getBook(BookVO bookVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info("책 페이지");
		
		mv.addObject("page", "book");
		mv.addObject("query", bookVO.getQuery());
		mv.setViewName("user/search/book");
		return mv;
	}
	
	@RequestMapping("/getBookList")
	public ModelAndView getBookList(BookVO bookVO) throws Exception {

		ModelAndView mv = new ModelAndView();
		Naver naver = new Naver();
		
		String url = Constant.BOOK_API_URL;
		HashMap<String, String> params = bookVO.getSearchKeywords();
		
		String searchInfo = naver.getSearchInfo(url, params);
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject)parser.parse(searchInfo);
		
		mv.addObject("searchList", json.get("items"));
		mv.addObject("total", json.get("total"));
		mv.addObject("display", json.get("display"));
		mv.setViewName("JsonView");
		
		return mv;		
	}
	
}
