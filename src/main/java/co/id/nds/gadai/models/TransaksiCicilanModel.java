package co.id.nds.gadai.models;

import java.sql.Timestamp;

public class TransaksiCicilanModel {
    private String id;
    private Integer totalNilaiTaksiran;
    private Float ltv;
    private Integer maksNilaiPinjaman;
    private Integer nilaiPencairan;
    private Integer biayaAdmin;
    private Float diskonAdmin;
    private Float biayaAdminAkhir;
    private Timestamp tglTransaksi;
    private Timestamp tglDeadline;
    private Integer biayaJasaPenyimpanan;
    private Integer biayaJasaPenyimpananPeriode;
    private Integer totalBiayaPenyimpanan;
    private Integer biayaAdminTutup;
    private Integer totalPengembalian;
    private Integer totalNilaiPinjaman;

    //data transaksi
    private String customerId;
    private String kodeProduk;
    private String namaProduk;
    private String noKtp;
    private String namaPelanggan;

    
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
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
