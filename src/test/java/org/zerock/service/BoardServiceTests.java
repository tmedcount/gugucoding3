package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testPrint() {
		
		log.info(service);
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(10L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("제목 수정합니다.");
		log.info("MODIFY RESULT: " + service.motify(board));
	}
	
	@Test
	public void testDelete() {
		
		log.info("REMOVE RESULT: " + service.remove(11L));
	}
	
	@Test
	public void testGet() {
		
		log.info(service.get(1L));
	}
	
	@Test
	public void testGetList() {
		
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("AAATest 테스트");
		board.setContent("AAAContent 테스트");
		board.setWriter("tester");
		
		Long bno = service.register(board);
		log.info("BNO: " + bno);		
	}
}
