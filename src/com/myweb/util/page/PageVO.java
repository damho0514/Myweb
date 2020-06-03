package com.myweb.util.page;

public class PageVO {
	//화면에 그려질 pageNation을 계산하는 클래스 (생성할 때 pageNum와 전체게시글 수를 가지고 계산)
	
	private int startPage; //게시글화면에 보여질 첫페이지번호
	private int endPage; //게시글화면에 보여질 마지막페이지번호
	private boolean prev, next; //다음, 이전버튼 활성화 여부
	
	private int pageNum; //현재조회하는 페이지 번호
	private int total; //전체게시글 수
	
	private int amount = 10; //한 페이지에서 몇개의 데이터를 보여줄건가
	
	//생성될 때 계산처리
	public PageVO(int pageNum, int total, int amount) {
		this.pageNum = pageNum; 
		this.total = total;
		this.amount = amount;
		
		//1. endPage계산
		//현재페이지가 1~10번이라면 -> 화면에 보여질 끝페이지 10
		//현재페이지가 14번이라면 -> 화면에 보여질 끝페이지는 20
		//공식:  (int)Math.ceil(페이지번호 / (double)보여질페이지수 ) * 보여질페이지 수 
		this.endPage = (int)Math.ceil( this.pageNum / (double) 5 ) * 5; 
		
		//2. startPage계산
		//공식: 끝페이지 - 보여질페이지 수 + 1
		this.startPage = endPage - 5 + 1;
		//3. 실제보여질 끝페이지 계산
		//만약 총 게시물이 52개라면? -> 페이지번호는 6까지 표시되야 함
		//만약 총 게시물이 105개라면? -> 페이지번호는 11까지 표시되야 함
		//공식: 실제끝번호 = (int)Math.ceil(전체게시글수 / 페이지에 보여지는 데이터 수)
		int realEnd = (int)Math.ceil( this.total / (double)this.amount  );
		
		//ex: 131개의 게시물
		//1번 페이지 클릭시 -> endPage는 10, realEnd은 14 (endPage로 세팅)
		//11번 페이지 클릭시 -> endPage는 20, realEnd은 14 (realEnd로 세팅)
		//결론: endPage > realEnd 라면 realEnd를 보여주면 됨
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}

		//4. 이전버튼
		//startPage는 1, 11, 21....101형태로 표기됨
		//startPage가 1보다 큰 경우는 true
		this.prev = this.startPage > 1;

		//5. 다음버튼
		this.next = realEnd > this.endPage; 
		
		
		System.out.println("시작페이지:" + startPage + ", 끝페이지:" + endPage);
	}

	//게터, 세터
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
	
	
	
}
