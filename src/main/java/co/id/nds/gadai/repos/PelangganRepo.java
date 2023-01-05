package co.id.nds.gadai.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.id.nds.gadai.entities.PelangganEntity;
import co.id.nds.gadai.globals.GlobalConstant;

@Repository
public interface PelangganRepo extends JpaRepository<PelangganEntity, String>, JpaSpecificationExecutor<PelangganEntity>{

    @Query(value = "SELECT COUNT(*) FROM ms_pelanggan WHERE rec_status = '"+ GlobalConstant.REC_STATUS_ACTIVE+"' AND LOWER(name) = LOWER(:name)", nativeQuery = true) 
    long countByName(@Param("name") String name);

    @Modifying
    @Query(value = "UPDATE ms_pelanggan SET rec_status = '" + GlobalConstant.REC_STATUS_NON_ACTIVE + "', deleter_id = ?2, deleted_date = NOW() " + "WHERE id = ?1", nativeQuery = true)
    Integer doDelete(Integer id, Integer deleterId);
    
}
