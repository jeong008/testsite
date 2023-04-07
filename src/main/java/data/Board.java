package data;

import java.sql.Date;

public class Board {


	String boardPass;
	String title;
	String content;
	String writer;
	String userId;
	
	int boardId;
	int views;
	int likes;

	Date writed;
	

	public String getBoardPass() {
		return boardPass;
	}

	public void setBoardPass(String boardPass) {
		this.boardPass = boardPass;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Date getWrited() {
		return writed;
	}

	public void setWrited(Date writed) {
		this.writed = writed;
	}

	
	
	@Override
	public String toString() {
		return "Board [boardPass=" + boardPass + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", userId=" + userId + ", boardId=" + boardId + ", views=" + views + ", likes=" + likes + ", writed="
				+ writed + "]";
	}
	
	

}
