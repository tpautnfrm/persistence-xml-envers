package com.tpa.persistence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Data;

@Entity
@Table(name = "factura")
@Audited
@Data
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "fecha_creacion")
	private Date fechaCreacion = new Date();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
	private List<DetalleFactura> detalle = new ArrayList<>();

	public void addDetalle(DetalleFactura det) {
		this.detalle.add(det);
	}

}
