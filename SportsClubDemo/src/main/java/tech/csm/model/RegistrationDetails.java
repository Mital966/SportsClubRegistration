package tech.csm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "registration_details")
public class RegistrationDetails implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registration_id")
	private Integer regId;
	
	@Column(name = "applicant_name")
	private String name;
	
	
	@Column(name = "email_id")
	private String email;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name = "club_id")
	private Club club;
	
	@ManyToOne
	@JoinColumn(name = "sports_id")
	private Sports sports; 
	
	@Column(name = "is_active")
	private String isActive;
	
}
