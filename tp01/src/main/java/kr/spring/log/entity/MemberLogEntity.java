package kr.spring.log.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class MemberLogEntity {

	@Id
	private String id;

	@Field(name = "type")
	private String type;

	@Field(name = "content")
	private String content;

	@Field(name = "reg_time")
	private Date regTime;

	// Getters
	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public Date getRegTime() {
		return regTime;
	}

	// Setters
	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
}
