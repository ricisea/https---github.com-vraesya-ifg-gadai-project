package co.id.nds.gadai.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tx_transaksi_barang")
public class TransaksiBarangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "jumlah")
    private Integer jumlah;

    @Column(name = "harga_satuan")
    private Float hargaSatuan;

    @Column(name = "total")
    private Float total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Float getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(Float hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
}
