package co.com.gaslissa.expo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.expo.entity.CierreEfectivo;

public interface CierreEfectivoRepository
		extends CrudRepository<CierreEfectivo, Long>, QueryDslPredicateExecutor<CierreEfectivo> {

	@Query("SELECT c FROM CierreEfectivo c WHERE c.fecha BETWEEN #{#desde} AND #{#hasta}")
	public List<CierreEfectivo> consultarCierres(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta);
	
	@Query("SELECT NEW java.lang.Integer(COUNT(c.idCierre)) FROM CierreEfectivo c WHERE c.fecha BETWEEN #{#desde} AND #{#hasta}")
	public Integer contarCierres(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta);
}
