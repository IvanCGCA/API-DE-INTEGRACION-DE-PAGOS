package com.integracion.service;

import com.integracion.model.Pago;
import java.util.List;
import java.util.Optional;

public interface PagoService {
    Pago crearPago(Pago pago);
    List<Pago> getAllPayments();
    Optional<Pago> getPaymentById(Long id);
    void deletePayment(Long id);
}