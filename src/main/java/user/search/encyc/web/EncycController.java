package user.search.encyc.web;

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
import user.search.encyc.service.EncycVO;
import user.search.encyc.service.EncycService;

@Controller
@RequestMapping("/search")
public class EncycController {

	private static final Logger logger = LoggerFactory.getLogger(EncycController.class);
	
	@Autowired
	private EncycService encycService;
	
	@RequestMapping("/encyc")
	public ModelAndView getEncyc(EncycVO encycVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info("백과 사전 페이지");
		
		mv.addObject("page", "encyc");
		mv.addObject("query", encycVO.getQuery());
		mv.setViewName("user/search/encyc");
		return mv;
	}
	
	@RequestMapping("/getEncycList")
	public ModelAndView getEncycList(EncycVO encycVO) throws Exception {

		ModelAndView mv = new ModelAndView();
		Naver naver = new Naver();
		
		String url = Constant.Encyc_API_URL;
		HashMap<String, String> params = encycVO.getSearchKeywords();
		
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
