package per.ljh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.ljh.mapper.RectificationLinkMapper;

/**
 * 
 * @author Ljh
 *
 */
@Service
public class RectificationLinkService {
	
	@Autowired
	private RectificationLinkMapper rectificationLinkMapper;
	
}
