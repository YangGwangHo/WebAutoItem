package com.user.domain;

public class BoardPage {
	
	public static final int PAGE_SCALE = 10;
	
	public static final int SCREEN_SCALE = 10;
	private int cursorPage;
	private int prePage;
	private int nextPage;
	private int totalPage;
	private int totalBlock;
	private int cursorBlock;
	private int preBlock;
	private int nextBlock;
	
	private int pageStart;
	private int pageEnd;
	
	private int blockStart;
	private int blockEnd;
	
	public BoardPage(int count,int cursorPage) {
		cursorBlock = 1;
		this.cursorPage = cursorPage;
		setTotalPage(count);
		setPageRange();
		setTotalBlock();
		setBlockRange();
	}
	
	public void setBlockRange() {
		cursorBlock = (int)Math.ceil((cursorPage-1)/SCREEN_SCALE)+1;
		blockStart = (cursorBlock-1)*SCREEN_SCALE+1;
		blockEnd = blockStart+SCREEN_SCALE-1;
		if(blockEnd>totalPage)
			blockEnd = totalPage;
		if(cursorPage == 1)
			prePage = 1;
		else
			prePage = (cursorBlock-1)*SCREEN_SCALE;
		if(cursorBlock>totalBlock)
			nextPage = cursorBlock*SCREEN_SCALE;
		else
			nextPage = cursorBlock*SCREEN_SCALE+1;
		if(nextPage >= totalPage)
			nextPage = totalPage;
	}
	
	public void setPageRange() {
		pageStart = (cursorPage-1)*PAGE_SCALE+1;
		pageEnd = pageStart+PAGE_SCALE-1;
	}

	public int getCursorPage() {
		return cursorPage;
	}

	public void setCursorPage(int cursorPage) {
		this.cursorPage = cursorPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int count) {
		totalPage = (int)Math.ceil(count*1.0/PAGE_SCALE);
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock() {
		totalBlock = (int)Math.ceil(totalPage/SCREEN_SCALE);
	}

	public int getCursorBlock() {
		return cursorBlock;
	}

	public void setCursorBlock(int cursorBlock) {
		this.cursorBlock = cursorBlock;
	}

	public int getPreBlock() {
		return preBlock;
	}

	public void setPreBlock(int preBlock) {
		this.preBlock = preBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockStart() {
		return blockStart;
	}

	public void setBlockStart(int blockStart) {
		this.blockStart = blockStart;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	
	
}
