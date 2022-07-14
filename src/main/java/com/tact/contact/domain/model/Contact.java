package com.tact.contact.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tact.core.domain.utilitary.ValidatorUtils;


@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@Column(name = "con_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "con_name", nullable = false, length = 150)
	private String name;

	@Column(name = "con_image_path", length = 255)
	private String imagePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = ValidatorUtils.isNullOrEmpty(name) ? null : name.trim();
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = ValidatorUtils.isNullOrEmpty(imagePath) ? null : imagePath.trim();
	}

}
