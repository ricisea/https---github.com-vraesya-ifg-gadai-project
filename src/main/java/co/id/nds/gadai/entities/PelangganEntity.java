package co.id.nds.gadai.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "ms_pelanggan")
public class PelangganEntity {
    //main
    @Id
    @GenericGenerator(name = "pelanggan_id_seq", strategy = "co.id.nds.gadai.generators.PelangganIdGenerator")
    @GeneratedValue(generator = "pelanggan_id_seq")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "no_ktp")
    private String no_ktp;

    @Column(name = "no_hp")
    private String no_hp;

    @Column(name = "jenis_kelamin")
    private String jenis_kelamin;

    @Column(name = "jenis_usaha")
    private String jenis_usaha;

    @Column(name = "max_limit_pinjaman")
    private Integer max_limit_pinjaman;

    @Column(name = "deleted_date")
    private Timestamp deletedDate;

    @Column(name = "deleter_id")
    private Integer deleterId;


    //joined column
    @OneToMany(targetEntity = TransaksiCicilanEntity.class, mappedBy = "customerId")
    private List<TransaksiCicilanEntity> transaksi;

    // status
    @Column(name = "rec_status") //return A active or N non active
    private String recStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getJenis_usaha() {
        return jenis_usaha;
    }

    public void setJenis_usaha(String jenis_usaha) {
        this.jenis_usaha = jenis_usaha;
    }

    public Integer getMax_limit_pinjaman() {
        return max_limit_pinjaman;
    }

    public void setMax_limit_pinjaman(Integer max_limit_pinjaman) {
        this.max_limit_pinjaman = max_limit_pinjaman;
    }

    public Timestamp getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Timestamp deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Integer getDeleterId() {
        return deleterId;
    }

    public void setDeleterId(Integer deleterId) {
        this.deleterId = deleterId;
    }

    public String getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }
    
}
