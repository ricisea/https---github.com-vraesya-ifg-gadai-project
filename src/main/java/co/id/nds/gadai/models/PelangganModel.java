package co.id.nds.gadai.models;

public class PelangganModel extends RecordModel{
    //main
    private String id;
    private String name;
    private String no_ktp;
    private String no_hp;
    private String jenis_kelamin;
    private String jenis_usaha;
    private Integer max_limit_pinjaman;
    
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

}
