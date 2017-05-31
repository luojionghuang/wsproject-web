package per.ljh.junit.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.ljh.junit.base.BaseJunit4Test;
import per.ljh.service.EnterpriseService;
import per.ljh.service.RectificationMainService;
import per.ljh.service.SituationService;

public class JunitTest extends BaseJunit4Test {
	
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private SituationService situationService;
	@Autowired
	private RectificationMainService checkRecordService;
	@Autowired
	private RectificationMainService mainService;
	
	@Test
	public void test() {
		mainService.loadRectificationMainById("297b1196-03d8-4810-8555-d8efe5e709f5");
	}
	
}
