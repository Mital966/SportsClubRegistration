package tech.csm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "club_master")
public class Club implements Serializable {

	@Id
	@Column(name = "club_id")
	private Integer clubId;
	
	@Column(name = "club_name")
	private String clubName;
	
}
