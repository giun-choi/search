package user.search.kin.web;

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
import user.search.kin.service.KinVO;
import user.search.kin.service.KinService;

@Controller
@RequestMapping("/search")
public class KinController {
	
	private static final Logger logger = LoggerFactory.getLogger(KinController.class);
	
	@Autowired
	private KinService kinService;
	
	@RequestMapping("/kin")
	public ModelAndView getKin(KinVO kinVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info("지식 iN 페이지");
		
		mv.addObject("page", "kin");
		mv.addObject("query", kinVO.getQuery());
		mv.setViewName("user/search/kin");
		return mv;
	}

	@RequestMapping("/getKinList")
	public ModelAndView getKinList(KinVO kinVO) throws Exception {

		ModelAndView mv = new ModelAndView();
		Naver naver = new Naver();
		
		String url = Constant.Kin_API_URL;
		HashMap<String, String> params = kinVO.getSearchKeywords();
		
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
