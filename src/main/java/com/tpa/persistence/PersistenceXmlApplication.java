package com.tpa.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tpa.persistence.entity.Articulo;
import com.tpa.persistence.entity.Categoria;
import com.tpa.persistence.entity.DetalleFactura;
import com.tpa.persistence.entity.Factura;

@SpringBootApplication
public class PersistenceXmlApplication {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploPersistenciaPU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

//		Categoria cat = createCategoria();
		
//		em.persist(cat);	
		
		Categoria c= em.find(Categoria.class, 1);
		
		em.remove(c);
		
		em.getTransaction().commit();
		

//		Articulo articulo = createArticulo(cat);
//
//		DetalleFactura detalle = createDetFactura(articulo);
//		Factura factura = createFactura(detalle);
//		detalle.setFactura(factura);
//		em.persist(cat);
//		em.persist(a);
//		em.persist(detalle);
//		em.persist(factura);

//		Categoria c= em.find(Categoria.class, 1);
//		System.out.println(c);
//		
//		Articulo art1 = em.find(Articulo.class, 1);
//		art1.setNombreArticulo("articulo5");
//		System.out.println(art1);
//
//		em.persist(art1);
//
//		Articulo art2 = em.find(Articulo.class, 2);
//		System.out.println(art2);
//
//		Factura fact1 = em.find(Factura.class, 1);
//
//		em.remove(fact1);

	

//		DetalleFactura dt = em.find(DetalleFactura.class, 1);
//		System.out.println(dt);
//
//		Factura fact = em.find(Factura.class, 1);
//		System.out.println(fact);

	}

	private static Categoria createCategoria() {

		Categoria c = new Categoria();
		c.setNombre("Primario");

		return c;
	}

	private static Articulo createArticulo(Categoria cat) {

//		Articulo a = new Articulo();
//		a.setNombreArticulo("articulo ABC");
//		a.setCategoria(cat);

		Articulo a = Articulo.builder()//
				.nombreArticulo("articulo ABC")//
				.categoria(cat)//
				.build();

		return a;

	}

	private static DetalleFactura createDetFactura(Articulo art) {
		DetalleFactura dt = new DetalleFactura();
		dt.setCantidad(2);
		dt.setArticulo(art);
		return dt;
	}

	private static Factura createFactura(DetalleFactura detalle) {
		Factura f = new Factura();
		f.addDetalle(detalle);
		return f;
	}

}
