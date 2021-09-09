package user.search.cafearticle.web;

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
import user.search.cafearticle.service.CafeArticleVO;
import user.search.cafearticle.service.CafearticleService;

@Controller
@RequestMapping("/search")
public class CafeArticleController {
	
	private static final Logger logger = LoggerFactory.getLogger(CafeArticleController.class);
	
	@Autowired
	private CafearticleService cafearticleService;
	
	@RequestMapping("/cafearticle")
	public ModelAndView getCafeArticle(CafeArticleVO cafearticleVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info("카페글 페이지");
		
		mv.addObject("page", "cafearticle");
		mv.addObject("query", cafearticleVO.getQuery());
		mv.setViewName("user/search/cafearticle");
		return mv;
	}
	
	@RequestMapping("/getCafeArticleList")
	public ModelAndView getCafeArticleList(CafeArticleVO cafearticleVO) throws Exception {

		ModelAndView mv = new ModelAndView();
		Naver naver = new Naver();
		
		String url = Constant.CafeArticle_API_URL;
		HashMap<String, String> params = cafearticleVO.getSearchKeywords();
		
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
