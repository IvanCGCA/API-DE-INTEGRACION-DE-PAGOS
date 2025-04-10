package com.integracion.service;

import com.integracion.model.Pago;
import com.integracion.repository.PagoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl implements PagoService{

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public Pago crearPago(Pago pago) {
    	pago.setStatus("pending");
        return pagoRepository.save(pago);
    }

    @Override
    public List<Pago> getAllPayments() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> getPaymentById(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    public void deletePayment(Long id) {
    	pagoRepository.deleteById(id);
    }
}