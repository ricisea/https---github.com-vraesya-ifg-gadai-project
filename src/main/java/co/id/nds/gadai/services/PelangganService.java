package co.id.nds.gadai.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.id.nds.gadai.entities.PelangganEntity;
import co.id.nds.gadai.exceptions.ClientException;
import co.id.nds.gadai.exceptions.NotFoundException;
import co.id.nds.gadai.globals.GlobalConstant;
import co.id.nds.gadai.models.PelangganModel;
import co.id.nds.gadai.repos.PelangganRepo;
import co.id.nds.gadai.repos.specs.PelangganSpec;
import co.id.nds.gadai.validators.PelangganValidator;

@Service
public class PelangganService implements Serializable{
    @Autowired
    private PelangganRepo pelangganRepo;

    PelangganValidator pelangganValidator = new PelangganValidator();

    public List<PelangganEntity> searchPelanggan(PelangganModel pelangganModel) {
        List<PelangganEntity> pelanggan = new ArrayList<>();
        PelangganSpec spec = new PelangganSpec(pelangganModel);
        pelangganRepo.findAll(spec).forEach(pelanggan::add);

        return pelanggan;
    }

    public List<PelangganEntity> getDetailPelanggan(){
        //validation
        List<PelangganEntity> pelanggan = new ArrayList<>();
        pelangganRepo.findAll().forEach(pelanggan::add);

        return pelanggan;
    }

    public PelangganEntity add (PelangganModel pelangganModel) throws ClientException{
        //validation
        pelangganValidator.notNullCheckCustomerId(pelangganModel.getId());
        pelangganValidator.nullCheckName(pelangganModel.getName());
        pelangganValidator.validateName(pelangganModel.getName());
        pelangganValidator.nullCheckNoKTP(pelangganModel.getNo_ktp());
        pelangganValidator.validateNoKTP(pelangganModel.getNo_ktp());
        pelangganValidator.nullCheckNoHP(pelangganModel.getNo_hp());
        pelangganValidator.validateNoHP(pelangganModel.getNo_hp());
        pelangganValidator.nullCheckJnsKlmn(pelangganModel.getJenis_kelamin());
        pelangganValidator.validateJnsKlmn(pelangganModel.getJenis_kelamin());
        pelangganValidator.nullCheckMaxLimit(pelangganModel.getMax_limit_pinjaman());
        pelangganValidator.validateMaxLimit(pelangganModel.getMax_limit_pinjaman());

        Long count = pelangganRepo.countByName(pelangganModel.getName());
        if (count > 0) {
            throw new ClientException("Customer name is already existed");
        }

        //process
        PelangganEntity pelanggan = new PelangganEntity();
        pelanggan.setName(pelangganModel.getName());
        pelanggan.setNo_ktp(pelangganModel.getNo_ktp());
        pelanggan.setNo_hp(pelangganModel.getNo_hp());
        pelanggan.setJenis_kelamin(pelangganModel.getJenis_kelamin());
        pelanggan.setJenis_usaha(pelangganModel.getJenis_usaha());
        pelanggan.setMax_limit_pinjaman(pelangganModel.getMax_limit_pinjaman());
        pelanggan.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);

        return pelangganRepo.save(pelanggan);

    }

    public PelangganEntity update (PelangganModel pelangganModel) throws ClientException, NotFoundException{
        //validate
        pelangganValidator.nullCheckCustomerId(pelangganModel.getId());
        pelangganValidator.validateCustomerId(pelangganModel.getId());

        if (!pelangganRepo.existsById(pelangganModel.getId())){
            throw new NotFoundException("Cannot find Customer with id "+ pelangganModel.getId());
        }

        //process
        PelangganEntity pelanggan = new PelangganEntity();
        pelanggan = findById(pelangganModel.getId());

        if (pelangganModel.getName() != null) {
            pelangganValidator.validateName(pelangganModel.getName());

            Long count = pelangganRepo.countByName(pelangganModel.getName());
            if (count > 0) {
                throw new ClientException("Customer name is already existed");
            }

            pelanggan.setName(pelangganModel.getName());
        }

        if (pelangganModel.getNo_ktp() != null) {
            pelangganValidator.validateNoKTP(pelangganModel.getNo_ktp());
            pelanggan.setNo_ktp(pelangganModel.getNo_ktp());
        }

        if (pelangganModel.getNo_hp() != null) {
            pelangganValidator.validateNoHP(pelangganModel.getNo_hp());
            pelanggan.setNo_hp(pelangganModel.getNo_hp());
        }

        if (pelangganModel.getJenis_kelamin() != null) {
            pelangganValidator.validateJnsKlmn(pelangganModel.getJenis_kelamin());
            pelanggan.setJenis_kelamin(pelangganModel.getJenis_kelamin());
        }

        if (pelangganModel.getJenis_usaha() != null) {
            pelanggan.setJenis_usaha(pelangganModel.getJenis_usaha());
        }

        if (pelangganModel.getMax_limit_pinjaman() != null) {
            pelangganValidator.validateMaxLimit(pelangganModel.getMax_limit_pinjaman());
            pelanggan.setMax_limit_pinjaman(pelangganModel.getMax_limit_pinjaman());
        }

        return pelangganRepo.save(pelanggan);
    }

    public PelangganEntity delete (PelangganModel pelangganModel) throws ClientException, NotFoundException{
        pelangganValidator.nullCheckCustomerId(pelangganModel.getId());
        pelangganValidator.validateCustomerId(pelangganModel.getId());

        if (!pelangganRepo.existsById(pelangganModel.getId())){
            throw new NotFoundException("Cannot find customer with id: "+pelangganModel.getId());
        }

        //process
        PelangganEntity pelanggan = new PelangganEntity();
        pelanggan = findById(pelangganModel.getId());

        if (pelanggan.getRecStatus().equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE)) {
            throw new ClientException("Customer id (" + pelangganModel.getId() + ") is already been deleted.");
           }
    
           pelanggan.setRecStatus(GlobalConstant.REC_STATUS_NON_ACTIVE);
           pelanggan.setDeletedDate(new Timestamp(System.currentTimeMillis()));
           pelanggan.setDeleterId(pelangganModel.getActorId() == null? 0 : pelangganModel.getActorId());
        
           return pelangganRepo.save(pelanggan);
    }

    public List<PelangganEntity> getListUsaha(PelangganModel pelangganModel) {
        List<PelangganEntity> pelanggan = new ArrayList<>();
        PelangganSpec spec = new PelangganSpec(pelangganModel);
        pelangganRepo.findAll(spec).forEach(pelanggan::add);

        return pelanggan;
    }

    //find by Id untuk update dan delete
    public PelangganEntity findById(String id) throws ClientException, NotFoundException {
        //validation
        pelangganValidator.nullCheckCustomerId(id);
        pelangganValidator.validateCustomerId(id);

        //process
        PelangganEntity pelanggan = pelangganRepo.findById(id).orElse(null);
        pelangganValidator.nullCheckObject(pelanggan);

        return pelanggan;
    }
}
