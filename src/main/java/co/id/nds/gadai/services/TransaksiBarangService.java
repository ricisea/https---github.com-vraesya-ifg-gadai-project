package co.id.nds.gadai.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.id.nds.gadai.entities.TransaksiBarangEntity;
import co.id.nds.gadai.exceptions.ClientException;
import co.id.nds.gadai.exceptions.NotFoundException;
import co.id.nds.gadai.models.TransaksiBarangModel;
import co.id.nds.gadai.repos.TransaksiBarangRepo;
import co.id.nds.gadai.validators.TransaksiBarangValidator;

@Service
public class TransaksiBarangService implements Serializable{
    @Autowired
    private TransaksiBarangRepo transaksiBarangRepo;

    TransaksiBarangValidator transaksiBarangValidator = new TransaksiBarangValidator();

    public TransaksiBarangEntity add(TransaksiBarangModel transaksiBarangModel) throws ClientException{
        transaksiBarangValidator.notNullCheckBarangId(transaksiBarangModel.getId());
        transaksiBarangValidator.nullCheckName(transaksiBarangModel.getNamaBarang());
        transaksiBarangValidator.validateName(transaksiBarangModel.getNamaBarang());
        transaksiBarangValidator.nullCheckJml(transaksiBarangModel.getJumlah());
        transaksiBarangValidator.validateJml(transaksiBarangModel.getJumlah());
        transaksiBarangValidator.nullCheckHarga(transaksiBarangModel.getHargaSatuan());
        transaksiBarangValidator.validateHarga(transaksiBarangModel.getHargaSatuan());

        Long count = transaksiBarangRepo.countByName(transaksiBarangModel.getNamaBarang());
        if (count > 0) {
         throw new ClientException("Product name is already existed");
        }

        //process
        TransaksiBarangEntity barang = new TransaksiBarangEntity();
        barang.setNamaBarang(transaksiBarangModel.getNamaBarang());
        barang.setDeskripsi(transaksiBarangModel.getDeskripsi());
        barang.setJumlah(transaksiBarangModel.getJumlah());
        barang.setHargaSatuan(transaksiBarangModel.getHargaSatuan());
        barang.setTotal(transaksiBarangModel.getJumlah() * transaksiBarangModel.getHargaSatuan());

        return transaksiBarangRepo.save(barang);
    }

    //find by id untuk edit dan delete
    public TransaksiBarangEntity findById(Integer id) throws ClientException, NotFoundException {
        //validation
        transaksiBarangValidator.nullCheckBarangId(id);
        transaksiBarangValidator.validateBarangId(id);
        
        //barang
        TransaksiBarangEntity barang = transaksiBarangRepo.findById(id).orElse(null);
        transaksiBarangValidator.nullCheckObject(barang);

        return barang;
}

    public TransaksiBarangEntity edit(TransaksiBarangModel transaksiBarangModel) throws ClientException, NotFoundException {
         //validation
         transaksiBarangValidator.nullCheckBarangId(transaksiBarangModel.getId());
         transaksiBarangValidator.validateBarangId(transaksiBarangModel.getId());

         if(!transaksiBarangRepo.existsById(transaksiBarangModel.getId())) {
            throw new NotFoundException("Tidak dapat menemukan barang dengan id "+transaksiBarangModel.getId());
         }

         //process
         TransaksiBarangEntity barang = new TransaksiBarangEntity();
         barang = findById(transaksiBarangModel.getId());

         if (transaksiBarangModel.getNamaBarang() != null) {
            transaksiBarangValidator.validateName(transaksiBarangModel.getNamaBarang());

            barang.setNamaBarang(transaksiBarangModel.getNamaBarang());
         }

         if (transaksiBarangModel.getDeskripsi() != null) {
            barang.setDeskripsi(transaksiBarangModel.getDeskripsi());
         }

         if (transaksiBarangModel.getJumlah() != null) {
            transaksiBarangValidator.validateJml(transaksiBarangModel.getJumlah());

            barang.setJumlah(transaksiBarangModel.getJumlah());
         }

         if (transaksiBarangModel.getHargaSatuan() != null) {
            transaksiBarangValidator.validateHarga(transaksiBarangModel.getHargaSatuan());

            barang.setHargaSatuan(transaksiBarangModel.getHargaSatuan());
         }

         return transaksiBarangRepo.save(barang);

    }

    public TransaksiBarangEntity delete(TransaksiBarangModel transaksiBarangModel) throws ClientException, NotFoundException {
         //validation
         transaksiBarangValidator.nullCheckBarangId(transaksiBarangModel.getId());
         transaksiBarangValidator.validateBarangId(transaksiBarangModel.getId());

         if(!transaksiBarangRepo.existsById(transaksiBarangModel.getId())) {
            throw new NotFoundException("Tidak dapat menemukan barang dengan id "+transaksiBarangModel.getId());
         }

         //process
         TransaksiBarangEntity barang = new TransaksiBarangEntity();
         barang = findById(transaksiBarangModel.getId());

         return transaksiBarangRepo.save(barang);

    }

}
