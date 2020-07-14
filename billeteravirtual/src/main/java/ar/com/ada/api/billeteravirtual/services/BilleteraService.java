package ar.com.ada.api.billeteravirtual.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.repos.BilleteraRepository;
@Service
public class BilleteraService {

    /* 1. Metodo: consultar saldo 
    1.1-- recibir el id de la billetera y la moneda en la que esta la cuenta
    */

    @Autowired
    BilleteraRepository repo;

    public void grabar(Billetera billetera){
        repo.save(billetera);
    }
    
}