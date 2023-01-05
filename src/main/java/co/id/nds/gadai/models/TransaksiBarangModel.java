package co.id.nds.gadai.models;

public class TransaksiBarangModel {
    private Integer id;
    private String namaBarang;
    private String deskripsi;
    private Integer jumlah;
    private Float hargaSatuan;
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
