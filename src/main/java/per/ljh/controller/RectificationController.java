package per.ljh.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import per.ljh.bean.branch.RectificationMainBranch;
import per.ljh.service.RectificationMainService;

/**
 * 
 * @author Ljh
 *
 */
@Controller
@RequestMapping("/rectification")
public class RectificationController {
	
	@Autowired
	private RectificationMainService rectificationMainService;

	/**
	 * 分页加载main
	 * @param curPage
	 * @param pageSize
	 * @param resp
	 * @return
	 */
	@RequestMapping("/loadRectificationMains")
	@ResponseBody
	public List<RectificationMainBranch> loadRectificationMains(Integer curPage, Integer pageSize, HttpServletResponse resp) {
		if(curPage == null) {
			return null;
		}
		if(pageSize == null) {
			pageSize = 10;
		}
		resp.setHeader("Access-Control-Allow-Origin", "*");
		return rectificationMainService.loadRectificationMainBranchsByParams(curPage, pageSize);
	}
	
}
