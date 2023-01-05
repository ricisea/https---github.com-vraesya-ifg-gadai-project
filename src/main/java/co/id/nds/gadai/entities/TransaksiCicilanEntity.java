package co.id.nds.gadai.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tx_transaksi_cicilan_tetap")
public class TransaksiCicilanEntity {
    @Id
    @GenericGenerator(name = "transaksi_id_seq", strategy = "co.id.nds.gadai.generators.TransaksiIdGenerator")
    @GeneratedValue(generator = "transaksi_id_seq")
    @Column(name = "id")
    private String id;

    @Column(name = "total_nilai_taksiran")
    private Integer totalNilaiTaksiran;

    @Column(name = "ltv")
    private Float ltv;

    @Column(name = "maks_nilai_pinjaman")
    private Integer maksNilaiPinjaman;

    @Column(name = "nilai_pencairan")
    private Integer nilaiPencairan;

    @Column(name = "biaya_admin")
    private Integer biayaAdmin;

    @Column(name = "diskon_admin")
    private Float diskonAdmin;

    @Column(name = "biaya_admin_akhir")
    private Float biayaAdminAkhir;

    @Column(name = "tanggal_transaksi")
    private Timestamp tglTransaksi;

    @Column(name = "tanggal_jatuh_tempo")
    private Timestamp tglDeadline;

    @Column(name = "biaya_jasa_penyimpanan")
    private Integer biayaJasaPenyimpanan;

    @Column(name = "biaya_jasa_penyimpanan_periode")
    private Integer biayaJasaPenyimpananPeriode;

    @Column(name = "total_biaya_penyimpanan")
    private Integer totalBiayaPenyimpanan;

    @Column(name = "biaya_admin_tutup")
    private Integer biayaAdminTutup;

    @Column(name = "total_pengembalian")
    private Integer totalPengembalian;

    @Column(name = "total_nilai_pinjaman")
    private Integer totalNilaiPinjaman;

    //data transaksi
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "kode_produk")
    private String kodeProduk;

    @Column(name = "nama_produk")
    private String  namaProduk;

    @Column(name = "no_ktp")
    private String noKtp;

    @Column(name = "nama_pelanggan")
    private String  namaPelanggan;

    //setter and getter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotalNilaiTaksiran() {
        return totalNilaiTaksiran;
    }

    public void setTotalNilaiTaksiran(Integer totalNilaiTaksiran) {
        this.totalNilaiTaksiran = totalNilaiTaksiran;
    }

    public Float getLtv() {
        return ltv;
    }

    public void setLtv(Float ltv) {
        this.ltv = ltv;
    }

    public Integer getMaksNilaiPinjaman() {
        return maksNilaiPinjaman;
    }

    public void setMaksNilaiPinjaman(Integer maksNilaiPinjaman) {
        this.maksNilaiPinjaman = maksNilaiPinjaman;
    }

    public Integer getNilaiPencairan() {
        return nilaiPencairan;
    }

    public void setNilaiPencairan(Integer nilaiPencairan) {
        this.nilaiPencairan = nilaiPencairan;
    }

    public Integer getBiayaAdmin() {
        return biayaAdmin;
    }

    public void setBiayaAdmin(Integer biayaAdmin) {
        this.biayaAdmin = biayaAdmin;
    }

    public Float getDiskonAdmin() {
        return diskonAdmin;
    }

    public void setDiskonAdmin(Float diskonAdmin) {
        this.diskonAdmin = diskonAdmin;
    }

    public Float getBiayaAdminAkhir() {
        return biayaAdminAkhir;
    }

    public void setBiayaAdminAkhir(Float biayaAdminAkhir) {
        this.biayaAdminAkhir = biayaAdminAkhir;
    }

    public Timestamp getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Timestamp tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public Timestamp getTglDeadline() {
        return tglDeadline;
    }

    public void setTglDeadline(Timestamp tglDeadline) {
        this.tglDeadline = tglDeadline;
    }

    public Integer getBiayaJasaPenyimpanan() {
        return biayaJasaPenyimpanan;
    }

    public void setBiayaJasaPenyimpanan(Integer biayaJasaPenyimpanan) {
        this.biayaJasaPenyimpanan = biayaJasaPenyimpanan;
    }

    public Integer getBiayaJasaPenyimpananPeriode() {
        return biayaJasaPenyimpananPeriode;
    }

    public void setBiayaJasaPenyimpananPeriode(Integer biayaJasaPenyimpananPeriode) {
        this.biayaJasaPenyimpananPeriode = biayaJasaPenyimpananPeriode;
    }

    public Integer getTotalBiayaPenyimpanan() {
        return totalBiayaPenyimpanan;
    }

    public void setTotalBiayaPenyimpanan(Integer totalBiayaPenyimpanan) {
        this.totalBiayaPenyimpanan = totalBiayaPenyimpanan;
    }

    public Integer getBiayaAdminTutup() {
        return biayaAdminTutup;
    }

    public void setBiayaAdminTutup(Integer biayaAdminTutup) {
        this.biayaAdminTutup = biayaAdminTutup;
    }

    public Integer getTotalPengembalian() {
        return totalPengembalian;
    }

    public void setTotalPengembalian(Integer totalPengembalian) {
        this.totalPengembalian = totalPengembalian;
    }

    public Integer getTotalNilaiPinjaman() {
        return totalNilaiPinjaman;
    }

    public void setTotalNilaiPinjaman(Integer totalNilaiPinjaman) {
        this.totalNilaiPinjaman = totalNilaiPinjaman;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    
}
