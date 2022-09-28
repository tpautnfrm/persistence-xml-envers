package com.tpa.persistence.audit;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import com.tpa.persistence.config.CustomListerner;

import lombok.Data;

@Data
@Entity
@RevisionEntity(value = CustomListerner.class)
public class Revision {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "seq")
	@RevisionNumber
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@RevisionTimestamp
	private Date fecha;
	
	

}
