package ru.perm.v.webflux1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String content = "";

	public Article() {
	}

	public Article(Long id, String content) {
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", content='" + content + '\'' +
				'}';
	}
}
