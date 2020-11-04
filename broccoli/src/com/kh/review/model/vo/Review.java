package com.kh.review.model.vo;

import java.sql.Date;

public class Review {
	private int reviewNo;	// 리뷰 번호
	private int pno;		// 상품번호
	private int memNo;		// 회원번호
	private Date regDate;	// 등록일
	private String reviewTitle;	// 리뷰제목
	private String reviewContent;	// 리뷰 내용
	private int clickNo;			// 조회수
	private int reviewRate;			//평점
	private int like;
	
	
	public Review() {}


	public Review(int reviewNo, int pno, int memNo, Date regDate, String reviewTitle, String reviewContent, int clickNo,
			int reviewRate, int like) {
		super();
		this.reviewNo = reviewNo;
		this.pno = pno;
		this.memNo = memNo;
		this.regDate = regDate;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.clickNo = clickNo;
		this.reviewRate = reviewRate;
		this.like = like;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public String getReviewTitle() {
		return reviewTitle;
	}


	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public int getClickNo() {
		return clickNo;
	}


	public void setClickNo(int clickNo) {
		this.clickNo = clickNo;
	}


	public int getReviewRate() {
		return reviewRate;
	}


	public void setReviewRate(int reviewRate) {
		this.reviewRate = reviewRate;
	}


	public int getLike() {
		return like;
	}


	public void setLike(int like) {
		this.like = like;
	}


	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", pno=" + pno + ", memNo=" + memNo + ", regDate=" + regDate
				+ ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", clickNo=" + clickNo
				+ ", reviewRate=" + reviewRate + ", like=" + like + "]";
	};
	
	
	
}