package per.ljh.util;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import com.deepoove.poi.NiceXWPFDocument;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.RenderData;
import com.deepoove.poi.data.TableRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.policy.RenderPolicy;
import com.deepoove.poi.render.RenderAPI;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;

/**
 * doc模板工具类
 * @author ljh
 *
 */
public class DocTemplateUtil {

	public static final XWPFTemplate generateDoc(String templateDoc, Map<String, Object> datas) {
		XWPFTemplate doc = XWPFTemplate.create(templateDoc);
		doc.registerPolicy("changeLog", new MyTablePolicy());
		RenderAPI.render(doc, datas);
		return doc;
	}
	
	public static class MyTablePolicy implements RenderPolicy {
		public void render(ElementTemplate runTemplateP, Object data, XWPFTemplate template) {
			NiceXWPFDocument doc = template.getXWPFDocument();
			RunTemplate runTemplate = (RunTemplate) runTemplateP;
			XWPFRun run = runTemplate.getRun();
			if (null == data)
				return;

			TableRenderData tableData = (TableRenderData) data;
			List<RenderData> headers = tableData.getHeaders();
			List<Object> datas = tableData.getDatas();
			if (datas == null || datas.isEmpty()) {
				// XWPFTable table = doc.createTable(2, headers.size());
				XWPFTable table = doc.insertNewTable(run, 2, headers.size());
				if (null == table) {
					return;
				}
				CTTblWidth width = table.getCTTbl().addNewTblPr().addNewTblW();
				width.setW(BigInteger.valueOf(tableData.getWidth()));
				width.setType(STTblWidth.DXA);
				createHeader(table, headers);
				doc.mergeCellsHorizonal(table, 1, 0, 2);
				XWPFTableCell cell = table.getRow(1).getCell(0);
				cell.setText(tableData.getNoDatadesc());

			} else {
				int size = datas.size();
				XWPFTable table = doc.insertNewTable(run, 1 + size, headers.size());
				CTTblWidth width = table.getCTTbl().addNewTblPr().addNewTblW();
				width.setW(BigInteger.valueOf(tableData.getWidth()));
				width.setType(STTblWidth.DXA);
				createHeader(table, headers);
				int i = 1;
				for (Object obj : datas) {
					String str = obj.toString();
					String[] split = str.split(";");
					int length = split.length;
					for (int m = 0; m < length; m++) {
						table.getRow(i).getCell(m).setText(split[m]);
					}
					i++;
				}
			}
			runTemplate.getRun().setText("", 0);
		}

		private void createHeader(XWPFTable table, List<RenderData> headers) {
			int i = 0;
			for (RenderData head : headers) {
				TextRenderData textHead = (TextRenderData) head;
				Style style = textHead.getStyle();
				String color = null == style ? null : style.getColor();
				table.getRow(0).getCell(i).setText(textHead.getText());
				if (null != color)
					table.getRow(0).getCell(i).setColor(color);
				i++;
			}
		}
	}

}
