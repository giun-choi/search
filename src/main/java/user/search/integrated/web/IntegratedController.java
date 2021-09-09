package user.search.integrated.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import user.search.integrated.service.IntegratedVO;
import user.search.integrated.service.IntegratedService;

@Controller
@RequestMapping("/search")
public class IntegratedController {

	private static final Logger logger = LoggerFactory.getLogger(IntegratedController.class);
	
	@Autowired
	private IntegratedService integratedService;
	
	@RequestMapping(value = "/integrated", method = RequestMethod.GET)
	public ModelAndView getIntegrated(IntegratedVO integratedVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		logger.info("통합 페이지");
		
		mv.addObject("page", "integrated");
		mv.addObject("query", integratedVO.getQuery());
		mv.setViewName("user/search/integrated");
		return mv;
	}
	
	
	
}
