package co.id.nds.gadai.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.id.nds.gadai.entities.TransaksiCicilanEntity;
import co.id.nds.gadai.exceptions.ClientException;
import co.id.nds.gadai.exceptions.NotFoundException;
import co.id.nds.gadai.models.TransaksiCicilanModel;
import co.id.nds.gadai.repos.TransaksiCicilanRepo;
import co.id.nds.gadai.validators.PelangganValidator;
import co.id.nds.gadai.validators.TransaksiCicilanValidator;



@Service
public class TransaksiCicilanService {
    @Autowired
    private TransaksiCicilanRepo transaksiCicilanRepo;

    TransaksiCicilanValidator transaksiCicilanValidator = new TransaksiCicilanValidator();
    PelangganValidator pelangganValidator = new PelangganValidator();

    public TransaksiCicilanEntity add(TransaksiCicilanModel transaksiCicilanModel) throws ClientException {
        // transaksiCicilanValidator.validateNilaiPencairan(transaksiCicilanModel.getNilaiPencairan());
        // transaksiCicilanValidator.validateDiskon(transaksiCicilanModel.getDiskonAdmin());
        // transaksiCicilanValidator.validateMinPencairan(transaksiCicilanModel.getNilaiPencairan());

        //process
        TransaksiCicilanEntity transaksi = new TransaksiCicilanEntity();
        transaksi.setTotalNilaiTaksiran(transaksiCicilanModel.getTotalNilaiTaksiran());
        transaksi.setLtv(transaksiCicilanModel.getLtv());
        transaksi.setMaksNilaiPinjaman(transaksiCicilanModel.getTotalNilaiTaksiran() ); // total nilai taksiran * ltv * transaksiCicilanModel.getLtv()
        transaksi.setNilaiPencairan(transaksiCicilanModel.getNilaiPencairan()); //jumlah yang ingin dipinjam pelanggan
        transaksi.setBiayaAdmin(transaksiCicilanModel.getBiayaAdmin());
        transaksi.setDiskonAdmin(transaksiCicilanModel.getDiskonAdmin());
        transaksi.setBiayaAdminAkhir(transaksiCicilanModel.getBiayaAdminAkhir()); // - (transaksiCicilanModel.getBiayaAdmin() * transaksiCicilanModel.getDiskonAdmin() / 100)
        transaksi.setTglTransaksi(new Timestamp(System.currentTimeMillis()));
        transaksi.setTglDeadline(transaksiCicilanModel.getTglDeadline());
        transaksi.setBiayaJasaPenyimpanan(transaksiCicilanModel.getBiayaJasaPenyimpanan());
        transaksi.setBiayaJasaPenyimpananPeriode(transaksiCicilanModel.getBiayaJasaPenyimpananPeriode());
        transaksi.setTotalBiayaPenyimpanan(transaksiCicilanModel.getTotalBiayaPenyimpanan());
        transaksi.setBiayaAdminTutup(transaksiCicilanModel.getBiayaAdminTutup());
        transaksi.setTotalPengembalian(transaksiCicilanModel.getTotalPengembalian());
        transaksi.setTotalNilaiPinjaman(transaksiCicilanModel.getTotalNilaiPinjaman()); 
        transaksi.setCustomerId(transaksiCicilanModel.getCustomerId());
        transaksi.setNoKtp(transaksiCicilanModel.getNoKtp());
        transaksi.setNamaPelanggan(transaksiCicilanModel.getNamaPelanggan());
        
        return transaksiCicilanRepo.save(transaksi);
    }

    public List<TransaksiCicilanEntity> searchTransaksi(String customerId) throws ClientException, NotFoundException {
        //validation
        pelangganValidator.nullCheckCustomerId(customerId);
        pelangganValidator.validateCustomerId(customerId);

        //process
        List<TransaksiCicilanEntity> transaksi = transaksiCicilanRepo.findTransaksiTetap(customerId);
        transaksiCicilanValidator.nullCheckObject(transaksi);

        return transaksi;
    }  

}
