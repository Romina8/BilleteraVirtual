package ar.com.ada.api.billeteravirtual.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;
import ar.com.ada.api.billeteravirtual.entities.*;
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

    public void cargarSaldo(BigDecimal saldo, String moneda, Integer billeteraId, 
    String conceptoOperacion, String detalle){

        Billetera billetera = repo.findByBilleteraId(billeteraId);

        Cuenta cuenta = billetera.getCuenta(moneda);

        Transaccion transaccion = new Transaccion();
        transaccion.setMoneda(moneda);
        transaccion.setFecha(new Date());
        transaccion.setConceptoOperacion(conceptoOperacion);
        transaccion.setDetalle(detalle);
        transaccion.setImporte(saldo);
        transaccion.setTipoOperacion(1);// 1 Entrada, 0 Salida
        transaccion.setEstadoId(2);// -1 Rechazada 0 Pendiente 2 Aprobada
        transaccion.setDeCuentaId(cuenta.getCuentaId());
        transaccion.setDeUsuarioId(billetera.getPersona().getUsuario().getUsuarioId());
        transaccion.setaUsuarioId(billetera.getPersona().getUsuario().getUsuarioId());
        transaccion.setaCuentaId(cuenta.getCuentaId());

        cuenta.agregarTransaccion(transaccion);

        BigDecimal saldoActual = cuenta.getSaldo();
        BigDecimal saldoNuevo = saldoActual.add(saldo);
        cuenta.setSaldo(saldoNuevo);

        this.grabar(billetera);
    }

    public BigDecimal consultarSaldo (Integer billeteraId, String moneda){

        Billetera billetera = repo.findByBilleteraId(billeteraId);

        Cuenta cuenta = billetera.getCuenta(moneda);

        return cuenta.getSaldo();

    }

    public Billetera buscarPorId(Integer id){

        return repo.findByBilleteraId(id);
    }
}