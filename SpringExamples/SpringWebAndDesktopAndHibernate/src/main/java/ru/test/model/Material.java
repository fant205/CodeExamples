package ru.test.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NSI_MATERIALS")
public class Material implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "GID")
	private String gid;

	@Column(name = "ShortName")
	private String shortName;

	public String getGid() {
		return gid;
	}

	public int getId() {
		return id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setShortName(String shortName) {
		shortName = shortName;
	}

	@Override
	public String toString() {
		return String.format("id: %s; GID: %s; shortName: %s", getId(), getGid(), getShortName());
	}

}