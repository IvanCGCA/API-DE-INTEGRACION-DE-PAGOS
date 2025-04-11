API DE INTEGRACION DE PAGOS

API pensada para implementar algun servicio de pagos, como Stripe por ejemplo


.................................................................................


Tecnologías usadas:

• Frontend: React.js, HTML, CSS
• Backend: Java (Spring Boot) 
• Mensajería: Kafka (local)
• Base de datos: SQLite 
• API: API RESTful para el backend

.................................................................................


INSTALACION Y USO DE BACKEND:

El backend se realizo en eclipse, es necesario contar con el o se sugiere,
instalar spring boot en eclipse, maven, algunas dependencias ya vienen
en el archivo POM no deberia generar mucho problema

Para ejecutar el codigo, es necesario actualizar el proyecto por medio de maven,
despues limpiar el proyecto, despues correr el codigo como java aplication


----------------------------------------------------------------------------------


INSTALACION Y USO DE FRONTEND

El frontend fue creado en VSCode, solo es necesario agregar las extensiones 
en el mismo IDE en cuanto a react.js, node.js, algunas visuales si se prefiere

Para ejecutar el codigo, desde la terminal se puede ejecutar el comando "npm start"


.....................................................................................


BASE DE DATOS

Para este proyecto se utilizo sqlite, sin embargo puede adaptarse a usar un SQL
mas poderoso.


.....................................................................................


KAFKA

ZOOKEEPEER:

Abre una terminal o línea de comandos y navega a la carpeta bin/windows dentro de tu instalación de Kafka:

cd C:\Kafka\kafka_2.13-3.3.2\bin\windows
Ejecuta el siguiente comando para iniciar Zookeeper:

zookeeper-server-start.bat ..\..\config\zookeeper.properties
Zookeeper debería iniciarse sin problemas. Deja la terminal abierta mientras Kafka y Zookeeper están en ejecución.

KAFKA:

En una nueva terminal, navega a la misma carpeta bin/windows:

cd C:\Kafka\kafka_2.13-3.3.2\bin\windows
Ejecuta el siguiente comando para iniciar Kafka:

kafka-server-start.bat ..\..\config\server.properties


Consultrar mensajes:

kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test_topic --from-beginning



.....................................................................................


SQLITE

Abrir una terminal e ir al directorio donde se tenga instalado sqlite:

C:\SQLITE>

C:\SQLITE>sqlite3 C:\Users\eclipse-workspace\IntegracionPagos\db\pagos.db


.....................................................................................

Crear Pago:

![image](https://github.com/user-attachments/assets/ae221c81-a92f-4c3e-bcc7-67ff060195b6)


Ver pagos:

![image](https://github.com/user-attachments/assets/16c0a042-e5c7-4528-a649-6f10a808e3fe)



Consultar pago:

![image](https://github.com/user-attachments/assets/08f33a91-00de-4b3f-95d0-5ee29057c30c)


Eliminar pago:

![image](https://github.com/user-attachments/assets/6dd4cb82-2668-4fd8-a735-3c47ac44c215)


Consola Kafka mensajes del topico: 

![image](https://github.com/user-attachments/assets/0d88eb4f-bc2b-4c99-a25e-ac4cdef4eefc)



Linkedin:

www.linkedin.com/in/ivan-vega-porras


