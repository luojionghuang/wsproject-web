package per.ljh.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import per.ljh.bean.Situation;
import per.ljh.bean.plugin.Message;
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
	 * @return
	 */
	@RequestMapping("/loadSituations")
	@ResponseBody
	public List<Situation> loadSituations() {
		return situationService.loadSituations();
	}
	
	/**
	 * 处理
	 * @param name
	 * @param sort
	 * @return
	 */
	@RequestMapping("/dealSituation")
	@ResponseBody
	public Message dealSituation(Integer id, String name, Integer sort) {
		if(StringUtils.isBlank(name) || sort == null) {
			return new Message(0, "参数错误！");
		}
		Situation situation = new Situation();
		situation.setName(name);
		situation.setSort(sort);
		if(id == null) {//id为空做添加操作
			if(situationService.insertSituation(situation)) {
				return new Message(1, "添加成功！");
			} else {
				return new Message(0, "添加失败！");
			}
		} else {
			situation.setId(id);
			if(situationService.modifySituation(situation)) {
				return new Message(1, "修改成功！");
			} else {
				return new Message(0, "修改失败！");
			}
		}
	}
	
	/**
	 * 删除违法行为
	 * @param id
	 * @return
	 */
	@RequestMapping("/delSituation")
	@ResponseBody
	public Message delSituation(Integer id) {
		if(id == null) {
			return new Message(0, "参数错误！");
		}
		if(situationService.delSituationById(id)) {
			return new Message(1, "删除成功！");
		} else {
			return new Message(0, "删除失败！");
		}
	}
	
}
