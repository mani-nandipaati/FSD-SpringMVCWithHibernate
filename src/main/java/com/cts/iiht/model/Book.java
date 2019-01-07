package com.cts.iiht.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Book implements Serializable{

	private static final long serialVersionUID = -5629942468340856617L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long bookId;
	
	@NotEmpty(message="Title is not expected to be blank")
	@Size(min=5, max=25, message="Title is expected to 5 to 25 chars in length")
	@Column
	String title;
	
	@NotNull(message = "Price can not be empty")
	@Min(value=50, message="Price can not be less than 50")
	@Max(value=1000, message="Price can not be greater than 1000")
	@Column
	double price;
	

	@NotNull(message = "Volume can not be empty")
	@Min(value=1, message="Volume can not be less than 1")
	@Max(value=50, message="Volume can not be greater than 50")
	@Column
	int volume;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Past
	@Column
	LocalDate publishDate;
	
	@ManyToOne
	@JoinColumn(name ="subject_subjectId")
	Subject subject;
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + "]";
	}
	
	
}