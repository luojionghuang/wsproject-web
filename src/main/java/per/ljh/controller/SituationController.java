package per.ljh.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import per.ljh.bean.Situation;
import per.ljh.service.SituationService;

/**
 * 
 * @author Ljh
 *
 */
@Controller
@RequestMapping("/situation")
public class SituationController {

	@Autowired
	private SituationService situationService;
	
	/**
	 * 加载全列表
	 * @param resp
	 * @return
	 */
	@RequestMapping("/loadSituations")
	@ResponseBody
	public List<Situation> loadSituations(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		return situationService.loadSituations();
	}
	
}
