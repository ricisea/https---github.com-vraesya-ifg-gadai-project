package co.id.nds.gadai.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.id.nds.gadai.entities.TransaksiCicilanEntity;

@Repository
@Transactional
public interface TransaksiCicilanRepo extends JpaRepository<TransaksiCicilanEntity, String>, JpaSpecificationExecutor<TransaksiCicilanEntity>{
    @Query(value = "SELECT COUNT(*) FROM tx_transaksi_cicilan_tetap", nativeQuery = true) 
    long countById(@Param("id") String id);

    @Query(value = "SELECT t.*, p.name AS nama_pelanggan FROM tx_transaksi_cicilan_tetap AS p"+"JOIN ms_pelanggan AS p ON t.customer_id = p.id "+"WHERE c.customer_id =?1", nativeQuery = true)
    List<TransaksiCicilanEntity> findTransaksiTetap(String customerId);
}
