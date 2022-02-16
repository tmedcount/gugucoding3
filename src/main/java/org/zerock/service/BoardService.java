package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	Long register(BoardVO board);
	
	BoardVO get(Long bno);
	
	int motify(BoardVO board);
	
	int remove(Long bno);
	
	List<BoardVO> getList();
}
