package per.ljh.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deepoove.poi.XWPFTemplate;

import net.sf.json.JSONObject;
import per.ljh.bean.RectificationLink;
import per.ljh.bean.RectificationMain;
import per.ljh.bean.branch.RectificationMainBranch;
import per.ljh.bean.ext.RectificationMainExt;
import per.ljh.bean.plugin.Message;
import per.ljh.bean.plugin.PagePlugin;
import per.ljh.service.RectificationMainService;
import per.ljh.util.DocTemplateUtil;

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
	 * @return
	 */
	@RequestMapping("/loadRectificationMains")
	@ResponseBody
	public PagePlugin<RectificationMainBranch> loadRectificationMains(Integer curPage, Integer pageSize) {
		if(curPage == null) {
			return null;
		}
		if(pageSize == null) {
			pageSize = 10;
		}
		PagePlugin<RectificationMainBranch> plugin = new PagePlugin<RectificationMainBranch>();
		int total = rectificationMainService.loadCountByParams();
		plugin.setCurPage(curPage);
		plugin.setTotal(total);
		List<RectificationMainBranch> list = rectificationMainService.loadRectificationMainBranchsByParams(curPage, pageSize);
		plugin.setList(list);
		return plugin;
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
	
	/**
	 * 初始化主表
	 * @param enterpriseId
	 * @return
	 */
	@RequestMapping("/initRectificationMain")
	@ResponseBody
	public Message initRectificationMain(String enterpriseId) {
		if(StringUtils.isBlank(enterpriseId)) {
			return new Message(0, "参数错误！");
		}
		RectificationMain main = new RectificationMain();
		main.setEnterpriseId(enterpriseId);
		if(rectificationMainService.insertRectificationMain(main)) {
			return new Message(1, "添加成功！");
		} else {
			return new Message(0, "添加失败！");
		}
	}
	
	/**
	 * 记录
	 * @param rectification
	 * @return
	 */
	@RequestMapping("/recordRectification")
	@ResponseBody
	public Message recordRectification(String rectification) {
		if(StringUtils.isBlank(rectification)) {
			return new Message(0, "参数错误！");
		}
		Map<String, Class<?>> clazzMap = new HashMap<String, Class<?>>();
		clazzMap.put("links", RectificationLink.class);
		RectificationMainExt ext = (RectificationMainExt)JSONObject.toBean(JSONObject.fromObject(rectification), RectificationMainExt.class, clazzMap);
		if(rectificationMainService.modifyRectification(ext)) {
			return new Message(1, "修改成功！", ext);
		} else {
			return new Message(0, "修改失败！");
		}
	}
	
	@RequestMapping("/exportDoc")
	public void exportDoc(String rectificationMainId, HttpServletResponse resp) {
		try {
			RectificationMainExt rm = rectificationMainService.loadRectificationMainById(rectificationMainId);
			System.out.println("bb");
			if(rm != null) {
				resp.setContentType("application/x-download;charset=utf-8");
				resp.setHeader("Content-Disposition", "attachment;fileName=" + rm.getEnterpriseName() + "-" + rm.getCheckDate() + "-" + "整改" + ".docx");
				Map<String, Object> datas = new HashMap<String, Object>();
				datas.put("checkDate", rm.getCheckDate());
				datas.put("enterpriseName", rm.getEnterpriseName());
				datas.put("enterpriseAddress", rm.getEnterpriseAddress());
				datas.put("checkPerson", rm.getCheckPerson());
				datas.put("dutyUnit", rm.getDutyUnit());
				datas.put("dutyPerson", rm.getDutyPerson());
				datas.put("finishDate", rm.getFinishDate());
				datas.put("remark", rm.getRemark());
				datas.put("fillUnit", rm.getFillUnit());
				datas.put("fillPerson", rm.getFillPerson());
//				List<String> situationList = new ArrayList<String>();
//				datas.put("situation", new TableRenderData(null, ));
				XWPFTemplate doc = DocTemplateUtil.generateDoc("D://rectification-template.docx", datas);
				OutputStream out = resp.getOutputStream();
				doc.write(out);
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
