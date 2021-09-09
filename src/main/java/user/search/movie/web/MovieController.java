package user.search.movie.web;

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
import user.search.movie.service.MovieVO;
import user.search.movie.service.MovieService;

@Controller
@RequestMapping("/search")
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movie")
	public ModelAndView getMovie(MovieVO movieVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info("영화 페이지");
		
		mv.addObject("page", "movie");
		mv.addObject("query", movieVO.getQuery());
		mv.setViewName("user/search/movie");
		return mv;
	}
	
	@RequestMapping("/getMovieList")
	public ModelAndView getMovieList(MovieVO movieVO) throws Exception {

		ModelAndView mv = new ModelAndView();
		Naver naver = new Naver();
		
		String url = Constant.MOVIE_API_URL;
		HashMap<String, String> params = movieVO.getSearchKeywords();
		
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
