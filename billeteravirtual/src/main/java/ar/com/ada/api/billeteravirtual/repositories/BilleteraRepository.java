package ar.com.ada.api.billeteravirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.ada.api.billeteravirtual.entities.Billetera;

@Repository
public interface BilleteraRepository extends JpaRepository<Billetera, Integer> {

    Billetera findByBilleteraId(Integer id);
    
}