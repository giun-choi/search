package user.search.webkr.web;

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
import user.search.webkr.service.WebkrVO;
import user.search.webkr.service.WebkrService;

@Controller
@RequestMapping("/search")
public class WebkrController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebkrController.class);
	
	@Autowired
	private WebkrService webkrService;
	
	@RequestMapping("/webkr")
	public ModelAndView getWebkr(WebkrVO webkrVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info("웹문서 페이지");
		
		mv.addObject("page", "webkr");
		mv.addObject("query", webkrVO.getQuery());
		mv.setViewName("user/search/webkr");
		return mv;
	}
	
	@RequestMapping("/getWebkrList")
	public ModelAndView getWebkrList(WebkrVO webkrVO) throws Exception {

		ModelAndView mv = new ModelAndView();
		Naver naver = new Naver();
		
		String url = Constant.WEBKR_API_URL;
		HashMap<String, String> params = webkrVO.getSearchKeywords();
		
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
