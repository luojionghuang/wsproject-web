package per.ljh.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import per.ljh.bean.branch.RectificationMainBranch;
import per.ljh.bean.ext.RectificationMainExt;
import per.ljh.bean.plugin.Message;
import per.ljh.service.RectificationLinkService;
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
	@Autowired
	private RectificationLinkService rectificationLinkService;

	/**
	 * 分页加载main
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/loadRectificationMains")
	@ResponseBody
	public List<RectificationMainBranch> loadRectificationMains(Integer curPage, Integer pageSize) {
		if(curPage == null) {
			return null;
		}
		if(pageSize == null) {
			pageSize = 10;
		}
		return rectificationMainService.loadRectificationMainBranchsByParams(curPage, pageSize);
	}
	
	/**
	 * id加载
	 * @param id
	 * @return
	 */
	@RequestMapping("/loadRectification/{id}")
	@ResponseBody
	public Message loadRectification(@PathVariable("id")String id) {
		if(StringUtils.isBlank(id)) {
			return new Message(0, "参数错误！");
		}
		RectificationMainExt rm = rectificationMainService.loadRectificationMainById(id);
		if(rm != null) {
			return new Message(1, rm);
		} else {
			return new Message(0, "请与管理员联系！");
		}
	}
	
	@RequestMapping("/recordRectification")
	@ResponseBody
	public Message recordRectification(@ModelAttribute RectificationMainExt rectification) {
		if(rectification == null) {
			return new Message(0, "参数错误！");
		}
		if(rectificationMainService.modifyRectification(rectification)) {
			return new Message(1, "修改成功！");
		} else {
			return new Message(0, "修改失败！");
		}
	}
	
}
