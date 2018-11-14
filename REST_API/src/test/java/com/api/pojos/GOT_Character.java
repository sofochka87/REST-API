package com.api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =true)
public class GOT_Character {

	String _id;
	String male;
	String house;
	String slug;
	String name;
	String __v;
	String pageRank;
	String books;
	String updatedAt;
	String createdAt;
	String titles;
	
	public GOT_Character(String _id, String male, String house, String slug, String name, String __v, String pageRank,
			String books, String updatedAt, String createdAt, String titles) {
		super();
		this._id = _id;
		this.male = male;
		this.house = house;
		this.slug = slug;
		this.name = name;
		this.__v = __v;
		this.pageRank = pageRank;
		this.books = books;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.titles = titles;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getMale() {
		return male;
	}
	public void setMale(String male) {
		this.male = male;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String get__v() {
		return __v;
	}
	public void set__v(String __v) {
		this.__v = __v;
	}
	public String getPageRank() {
		return pageRank;
	}
	public void setPageRank(String pageRank) {
		this.pageRank = pageRank;
	}
	public String getBooks() {
		return books;
	}
	public void setBooks(String books) {
		this.books = books;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	@Override
	public String toString() {
		return "GOT_Character [_id=" + _id + ", male=" + male + ", house=" + house + ", slug=" + slug + ", name=" + name
				+ ", __v=" + __v + ", pageRank=" + pageRank + ", books=" + books + ", updatedAt=" + updatedAt
				+ ", createdAt=" + createdAt + ", titles=" + titles + "]";
	}
	
	
	
}
