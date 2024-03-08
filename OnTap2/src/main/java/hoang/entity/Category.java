package hoang.entity;
// Generated Mar 8, 2024, 9:41:02 AM by Hibernate Tools 5.6.15.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category implements java.io.Serializable {

	private Integer categoryId;
	private String categoryName;
	private Set books = new HashSet(0);

	public Category() {
	}

	public Category(Integer categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Serializable getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

}