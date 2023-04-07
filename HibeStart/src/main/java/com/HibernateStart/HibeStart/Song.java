package com.HibernateStart.HibeStart;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Song {
	@Id
	private int id;
	private String sname;
	private String singer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Song(int id, String sname, String singer) {
		super();
		this.id = id;
		this.sname = sname;
		this.singer = singer;
	}

	public Song() {
		super();
	}

	
}
