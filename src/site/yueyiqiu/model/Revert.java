package site.yueyiqiu.model;

import java.util.Date;

public class Revert {
	
	private int id;
	private String content;
	private Date replytime;
	private Message message;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the replytime
	 */
	public Date getReplytime() {
		return replytime;
	}
	/**
	 * @param replytime the replytime to set
	 */
	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}
	/**
	 * @return the message
	 */
	public Message getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(Message message) {
		this.message = message;
	}
	
	
	
}
