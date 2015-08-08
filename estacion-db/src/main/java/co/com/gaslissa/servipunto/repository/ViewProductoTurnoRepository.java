/**
 * 
 */
package co.com.gaslissa.servipunto.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.gaslissa.servipunto.entity.ViewProductosTurno;

/**
 * @author Jorge
 *
 */
@Repository
@Transactional(readOnly = true)
public class ViewProductoTurnoRepository{
	
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @param desde
	 * @param hasta
	 * @param turno
	 * @param isla
	 * @return
	 */
	public List<ViewProductosTurno> consultarProductosTurno(
			Date desde,
			Date hasta,
			int turno,
			List<Integer> isla
			){
		Query query = em.createQuery("SELECT NEW co.com.gaslissa.servipunto.entity.ViewProductosTurno(v.fecha, v.galones, v.isla, v.producto, v.turno, v.valor) FROM ViewProductosTurno v WHERE v.fecha BETWEEN :desde AND :hasta AND v.turno = :turno AND v.isla IN(:isla)");
		query.setParameter("desde", desde);
		query.setParameter("hasta", hasta);
		query.setParameter("turno", turno);
		query.setParameter("isla", isla);
		
		return query.getResultList();
	}
	
	/**
	 * 
	 * @param desde
	 * @param hasta
	 * @param turno
	 * @param isla
	 * @return
	 */
	public Double consultarTotalProductosTurno(
			Date desde,
			Date hasta,
			int turno,
			List<Integer> isla
			){
		Query query = em.createQuery("SELECT NEW java.lang.Double(SUM(v.valor)) FROM ViewProductosTurno v WHERE v.fecha BETWEEN :desde AND :hasta AND v.turno = :turno AND v.isla IN(:isla)");
		query.setParameter("desde", desde);
		query.setParameter("hasta", hasta);
		query.setParameter("turno", turno);
		query.setParameter("isla", isla);
		
		return (Double) query.getSingleResult();
	}
	
	/**
	 * 
	 * @param desde
	 * @param hasta
	 * @return
	 */
	public List<ViewProductosTurno> consultarProductosAgrupados(
			Date desde,
			Date hasta
			){
		Query query = em.createQuery("SELECT NEW co.com.gaslissa.servipunto.entity.ViewProductosTurno(v.fecha, SUM(v.galones), v.isla, v.producto, v.turno, SUM(v.valor)) FROM ViewProductosTurno v WHERE v.fecha BETWEEN :desde AND :hasta GROUP BY v.fecha, v.producto");
		query.setParameter("desde", desde);
		query.setParameter("hasta", hasta);
		
		return query.getResultList();
	}
	
	/**
	 * 
	 * @param desde
	 * @param hasta
	 * @return
	 */
	public Double consultarTotalConsumo(
			Date desde,
			Date hasta
			){
		Query query = em.createQuery("SELECT NEW java.lang.Double(SUM(v.valor)) FROM ViewProductosTurno v WHERE v.fecha BETWEEN :desde AND :hasta");
		query.setParameter("desde", desde);
		query.setParameter("hasta", hasta);
		
		return (Double) query.getSingleResult();
	}
	
	/**
	 * 
	 * @param desde
	 * @param hasta
	 * @return
	 */
	public Double consultarTotalGalones(
			Date desde,
			Date hasta
			){
		Query query = em.createQuery("SELECT NEW java.lang.Double(SUM(v.galones)) FROM ViewProductosTurno v WHERE v.fecha BETWEEN :desde AND :hasta");
		query.setParameter("desde", desde);
		query.setParameter("hasta", hasta);
		
		return (Double) query.getSingleResult();
	}
}
