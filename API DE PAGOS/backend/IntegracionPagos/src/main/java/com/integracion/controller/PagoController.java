package com.integracion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integracion.model.Pago;
import com.integracion.repository.PagoRepository;
import com.integracion.service.KafkaMessageProducer;
import com.integracion.service.PagoService;


@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "http://localhost:3000") // Configuración de CORS
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private PagoService pagoService;
    
    private final KafkaMessageProducer kafkaMessageProducer;
    
    public PagoController(KafkaMessageProducer kafkaMessageProducer) {
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    
    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    
    @GetMapping("/db-url")
    public String getDatabaseUrl() {
        return "Conectado a la base de datos: " + datasourceUrl;
    }
    
   
    //API RESTFUL
    
    @PostMapping
    public Pago createPayment(@RequestBody Pago pago) {
    	Pago nuevoPago = pagoService.crearPago(pago);        
        // Enviar mensaje a Kafka
    	String mensajeKafka = pago.toString();
    	kafkaMessageProducer.enviarMensaje(mensajeKafka);
        
        return nuevoPago;
        
    }
    @GetMapping
    public List<Pago> getAllPayments() {
    	// Enviar mensaje a Kafka
    	String mensajeKafka = "Se mandan todos los registros";
    	kafkaMessageProducer.enviarMensaje(mensajeKafka);
        return pagoService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Optional<Pago> getPaymentById(@PathVariable Long id) {
        Optional<Pago> pagoOptional = pagoService.getPaymentById(id);
        
        if (pagoOptional.isPresent()) {
            // Enviar mensaje a Kafka
            String mensajeKafka = "Pago consultado con ID: " + id;
            kafkaMessageProducer.enviarMensaje(mensajeKafka);
        }
        
        return pagoOptional;
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {
        Optional<Pago> pagoOptional = pagoRepository.findById(id);
        
        if (pagoOptional.isPresent()) {
            pagoService.deletePayment(id);
            
            // Enviar mensaje a Kafka
            String mensajeKafka = "Pago eliminado con ID: " + id;
            kafkaMessageProducer.enviarMensaje( mensajeKafka);
            
            return "Pago eliminado exitosamente";
        } else {
            throw new RuntimeException("Pago no encontrado con ID: " + id);
        }
    }
    
    // Endpoint para enviar mensajes
    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
    	if (message == null || message.isEmpty()) {
    	    return "Error: El mensaje no puede estar vacío";
    	}
    	try {
    		kafkaMessageProducer.enviarMensaje(message);
    	    return "Mensaje enviado a Kafka: " + message;
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    return "Error al enviar el mensaje a Kafka: " + e.getMessage();
    	}
    }
    
}