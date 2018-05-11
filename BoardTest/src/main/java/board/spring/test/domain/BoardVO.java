package board.spring.test.domain;

import java.sql.Timestamp;

public class BoardVO {
	private int bno; // 게시글 번호
	private String title; // 게시글 제목
	private String content; // 게시글 내용
	private String writer; // 게시글 작성자
	private Timestamp regdate; // 게시글 작성일자
	private int viewcnt; // 게시글 조회수
	private String username; // 게시글 회원이름 = 게시글 작성자

	public BoardVO() {

	}

	public BoardVO(int bno, String title, String content, String writer, Timestamp regdate, int viewcnt) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String user_name) {
		this.username = user_name;
	}

	@Override
    public String toString() {
        return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
                + regdate + ", viewcnt=" + viewcnt + ", user_name=" + username + "]";
    }
}