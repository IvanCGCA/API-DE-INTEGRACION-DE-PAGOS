import React, { useState } from 'react';
import axios from 'axios';

function PaymentActions({ selectedAction }) {
  const [amount, setAmount] = useState('');
  const [card, setCard] = useState('');
  const [paymentId, setPaymentId] = useState('');
  const [paymentStatus, setPaymentStatus] = useState('');
  const [payments, setPayments] = useState([]);

  const handleCreatePayment = async () => {
    const paymentData = { tarjeta: card, monto: amount };
    try {
      const response = await axios.post('http://localhost:8081/api/pagos', paymentData);
      setPaymentStatus(`Pago creado con éxito: ${response.data.id}`);
    } catch (error) {
      setPaymentStatus(`Error al crear el pago: ${error.message}`);
    }
  };

  const handleGetAllPayments = async () => {
    try {
      const response = await axios.get('http://localhost:8081/api/pagos');
      setPayments(response.data);
      setPaymentStatus('Pagos obtenidos con éxito.');
    } catch (error) {
      setPaymentStatus(`Error al obtener los pagos: ${error.message}`);
    }
  };

  const handleGetPaymentById = async () => {
    try {
      const response = await axios.get(`http://localhost:8081/api/pagos/${paymentId}`);
      setPayments([response.data]);
      setPaymentStatus(`Pago obtenido con éxito: ${response.data.id}`);
    } catch (error) {
      setPaymentStatus(`Error al obtener el pago: ${error.message}`);
    }
  };

  const handleDeletePayment = async () => {
    try {
      await axios.delete(`http://localhost:8081/api/pagos/${paymentId}`);
      setPaymentStatus(`Pago eliminado con éxito.`);
    } catch (error) {
      setPaymentStatus(`Error al eliminar el pago: ${error.message}`);
    }
  };

  const renderForm = () => {
    switch (selectedAction) {
      case 'create':
        return (
          <div>
            <h3>Crear Pago</h3>
            <input
              type="text"
              placeholder="Número de tarjeta"
              value={card}
              onChange={(e) => setCard(e.target.value)}
            />
            <input
              type="number"
              placeholder="Monto"
              value={amount}
              onChange={(e) => setAmount(e.target.value)}
            />
            <button onClick={handleCreatePayment}>Crear Pago</button>
          </div>
        );
      case 'getAll':
        return (
          <div>
            <h3>Todos los Pagos</h3>
            <button onClick={handleGetAllPayments}>Ver Pagos</button>
            {payments.length > 0 && (
              <ul>
                {payments.map((payment) => (
                  <li key={payment.id}>
                    {payment.id} - {payment.monto} - {payment.status}
                  </li>
                ))}
              </ul>
            )}
          </div>
        );
      case 'getById':
        return (
          <div>
            <h3>Buscar Pago por ID</h3>
            <input
              type="number"
              placeholder="ID de pago"
              value={paymentId}
              onChange={(e) => setPaymentId(e.target.value)}
            />
            <button onClick={handleGetPaymentById}>Buscar</button>
            {payments.length > 0 && (
              <div>
                <p>Pago encontrado:</p>
                <p>{`ID: ${payments[0].id}, Monto: ${payments[0].monto}, Estado: ${payments[0].status}`}</p>
              </div>
            )}
          </div>
        );
      case 'delete':
        return (
          <div>
            <h3>Eliminar Pago</h3>
            <input
              type="number"
              placeholder="ID de pago"
              value={paymentId}
              onChange={(e) => setPaymentId(e.target.value)}
            />
            <button onClick={handleDeletePayment}>Eliminar</button>
          </div>
        );
      default:
        return null;
    }
  };

  return (
    <div className="payment-actions">
      {renderForm()}
      {paymentStatus && <p>{paymentStatus}</p>}
    </div>
  );
}

export default PaymentActions;