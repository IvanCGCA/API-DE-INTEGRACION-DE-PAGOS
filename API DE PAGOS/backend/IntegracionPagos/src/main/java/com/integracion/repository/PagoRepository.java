package com.integracion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.integracion.model.Pago;

import jakarta.transaction.Transactional;

public interface PagoRepository extends JpaRepository<Pago, Long> {
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO pago (monto, tarjeta) VALUES (:monto, :tarjeta)", nativeQuery = true)
    void insertarPago(@Param("monto") Double monto, @Param("tarjeta") String tarjeta);
}