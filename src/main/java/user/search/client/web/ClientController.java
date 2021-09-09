package user.search.client.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import base.utils.HttpUtil;
import user.search.client.service.ClientService;
import user.search.client.service.ClientVO;

@Controller
@RequestMapping("/client")
public class ClientController {

	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/setSearchInfo")
	public ModelAndView setSearchInfo(HttpServletRequest request, ClientVO clientVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		clientVO.setClient_ip(HttpUtil.getClientIP(request));
		clientVO.setSearch_word(clientVO.getSearch_word().replaceAll("_", "&"));
		
		int result = clientService.setSearchWord(clientVO);
		
		if(result == 1) logger.info("검색정보 저장완료");
		else logger.info("검색정보 저장실패");
		
		mv.addObject("result", result);
		mv.setViewName("JsonView");
		return mv;
	}
	
	@RequestMapping("/setClickInfo")
	public ModelAndView setClickInfo(HttpServletRequest request, ClientVO clientVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		clientVO.setClient_ip(HttpUtil.getClientIP(request));
		clientVO.setSearch_word(clientVO.getSearch_word().replaceAll("_", "&"));
		clientVO.setClick_link(clientVO.getClick_link().replaceAll("_", "&"));
		
		int result = clientService.setClickLink(clientVO);
		
		if(result == 1) logger.info("검색정보 저장완료");
		else logger.info("검색정보 저장실패");
		
		mv.addObject("result", result);
		mv.setViewName("JsonView");
		return mv;
	}
	
	
	
}
