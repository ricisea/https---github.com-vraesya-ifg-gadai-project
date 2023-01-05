package co.id.nds.gadai.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.id.nds.gadai.entities.TransaksiBarangEntity;

@Repository
public interface TransaksiBarangRepo extends JpaRepository<TransaksiBarangEntity, Integer>, JpaSpecificationExecutor<TransaksiBarangEntity>{
    @Query(value = "SELECT COUNT(*) FROM tx_transaksi_barang", nativeQuery = true) 
    long countByName(@Param("nama_barang") String namaBarang);

}
