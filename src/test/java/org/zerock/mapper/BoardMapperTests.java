package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		
		boardMapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testInsert() {
		
		BoardVO board = BoardVO.builder()
				.title("�깉濡� �옉�꽦�븯�뒗 湲�")
				.content("�깉濡� �옉�꽦�븯�뒗 �궡�슜")
				.writer("newbie")
				.build();
		
		boardMapper.insert(board);
		
		log.info(board);
		
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = BoardVO.builder()
				.title("�깉濡� �옉�꽦�븯�뒗 湲�2")
				.content("�깉濡� �옉�꽦�븯�뒗 �궡�슜2")
				.writer("newbie2")
				.build();
		
		boardMapper.insertSelectKey(board);
		
		log.info(board);
		
	}
	
	@Test
	public void testRead() {

		BoardVO board = boardMapper.read(9L);
		
		log.info(board);
	}

	@Test
	public void testDelete() {
		
		boardMapper.delete(9L);	
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board  = BoardVO.builder()
				.title("�닔�젙�맂 �젣紐�")
				.content("�닔�젙�맂 �궡�슜")
				.writer("�닔�젙�옄")
				.bno(8L)
				.build();
		
		boardMapper.update(board);			
	}

	@Test
	public void testGetListWithPageing() {
		Criteria cri = new Criteria(2, 10);
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		
		list.forEach(vo->log.info(vo));
		
		
	}
	
}

















