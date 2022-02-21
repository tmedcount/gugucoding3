package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PageDTO {
	
	private int startPage, endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
								//1.4 -> 2 -> 20
		this.endPage = (int) (Math.ceil(cri.getPageNum()/10.0)) * 10;
		
		this.startPage = endPage - 9;
		
		this.prev = this.startPage > 1;
								//294.0/10 -> 29.4 -> 30
		int realEnd = (int) (Math.ceil( (total*1.0) / cri.getAmount() ) );
		
		this.endPage = (realEnd <= endPage) ? realEnd : endPage;
		
		this.next = this.endPage < realEnd;
	}
}
