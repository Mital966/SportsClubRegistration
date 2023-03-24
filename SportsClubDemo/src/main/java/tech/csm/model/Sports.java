package tech.csm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name = "sports_master")
public class Sports implements Serializable {

	@Id
	@Column(name = "sports_id")
	private Integer sportsId;
	
	@Column(name = "sports_name")
	private String sportsName;
	
	@ManyToOne
	@JoinColumn(name = "club_id")
	private Club club;
	
	private Double fees;
}
