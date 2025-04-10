import React, { useState } from 'react';
import './App.css';
import PaymentActions from './components/PaymentActions'; // Nuevo componente que vamos a crear

function App() {
  const [selectedAction, setSelectedAction] = useState('create'); // Estado para manejar la acción seleccionada

  return (
    <div className="App">
      <h1>API Integración de Pagos</h1>
      
      <div>
        <label htmlFor="action">Seleccione una acción: </label>
        <select
          id="action"
          value={selectedAction}
          onChange={(e) => setSelectedAction(e.target.value)}
        >
          <option value="create">Crear Pago</option>
          <option value="getAll">Ver Todos los Pagos</option>
          <option value="getById">Buscar Pago por ID</option>
          <option value="delete">Eliminar Pago</option>
        </select>
      </div>

      <PaymentActions selectedAction={selectedAction} />
    </div>
  );
}

export default App;