package user.search.doc.web;

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
import user.search.doc.service.DocVO;
import user.search.doc.service.DocService;

@Controller
@RequestMapping("/search")
public class DocController {

	private static final Logger logger = LoggerFactory.getLogger(DocController.class);
	
	@Autowired
	private DocService docService;
	
	@RequestMapping("/doc")
	public ModelAndView getDoc(DocVO docVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info("전문자료 페이지");
		
		mv.addObject("page", "doc");
		mv.addObject("query", docVO.getQuery());
		mv.setViewName("user/search/doc");
		return mv;
	}
	
	@RequestMapping("/getDocList")
	public ModelAndView getDocList(DocVO docVO) throws Exception {

		ModelAndView mv = new ModelAndView();
		Naver naver = new Naver();
		
		String url = Constant.DOC_API_URL;
		HashMap<String, String> params = docVO.getSearchKeywords();
		
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
