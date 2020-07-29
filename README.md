# BilleteraVirtual
WEB API.Spring Boot. Se encuentra deployado en la plataforma de Heroku. 
La BilleteraVirtual es un sistema de transferencia de dinero electrónico
con el que se pueden hacer múltiples operaciones financieras: enviar 
saldo, consultar saldo y cargar saldo. 

#Base de datos
En un primer momento se conectaba a una base de datos de MySQL, pero al 
deployarla la app se cambió a una base de datos que soporte Heroku, en 
este caso Postman. se utilizó Postman para probar la WEB API.

#Mailgun
Se utilizó el servicio de MAILGUN para poder notificar con mails transaccionales 
los movimientos relizados en la billetera.

#Heroku
Se deployó en Heroku con una base de datos de Postgre (url:
https://tubilleterav.herokuapp.com).
