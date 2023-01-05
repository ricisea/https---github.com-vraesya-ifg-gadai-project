package co.id.nds.gadai.validators;

import co.id.nds.gadai.exceptions.ClientException;
import co.id.nds.gadai.exceptions.NotFoundException;
import co.id.nds.gadai.globals.GlobalConstant;

public class PelangganValidator {
    
    public void nullCheckCustomerId(String id) throws ClientException {
        if (id == null) {
            throw new ClientException("Customer id is required!");
        }
    }

    public void notNullCheckCustomerId(String id) throws ClientException {
        if (id != null) {
            throw new ClientException("Customer id is auto generated, do not input id!");
        }
    }

    public void nullCheckName(String name) throws ClientException {
        if (name == null) {
            throw new ClientException("Customer name is required!");
        }
    }

    public void nullCheckNoKTP(String no_ktp) throws ClientException {
        if (no_ktp == null) {
            throw new ClientException("Customer KTP is required!");
        }
    }

    public void nullCheckNoHP(String no_hp) throws ClientException {
        if (no_hp == null) {
            throw new ClientException("Customer phone number is required!");
        }
        
    }

    public void nullCheckJnsKlmn(String jenis_kelamin) throws ClientException {
        if(jenis_kelamin == null){
            throw new ClientException("Customer sex is required!");
        }
    }

    public void nullCheckJnsUsh(String jenis_usaha) throws ClientException {
        if(jenis_usaha == null) {
            throw new ClientException("Customer type of business number is required!");
        }
    }

    public void nullCheckMaxLimit(Integer max_limit_pinjaman) throws ClientException {
        if (max_limit_pinjaman == 0) {
            throw new ClientException("Customer max limit can not be null!");
        } 
    }

    public void nullCheckObject(Object o) throws NotFoundException {
        if (o == null) {
            throw new NotFoundException("Product is not found!");
        }
    }

    public void validateCustomerId(String id) throws ClientException {
        if (id.length() != 10 || !id.startsWith("YYMM")) {
            throw new ClientException("Customer id input is invalid!");
        }
    }

    public void validateName(String name) throws ClientException {
        if (name.trim().equalsIgnoreCase("")) {
            throw new ClientException("Customer name is required!");
        }
    }

    public void validateNoKTP(String no_ktp) throws ClientException {
        if (no_ktp.length() != 16) {
            throw new ClientException("Customer KTP must contain 16 digits!");
        }
    }

    public void validateNoHP(String no_hp) throws ClientException {
        if (no_hp.length() < 9 && no_hp.length() > 12) {
            throw new ClientException("Customer phone number input must contain minimun 9 dan max 12 digits!");
        }
    }

    public void validateJnsKlmn(String jenis_kelamin) throws ClientException {
        if (!jenis_kelamin.equalsIgnoreCase("l") && !jenis_kelamin.equalsIgnoreCase("p")) {
            throw new ClientException("Customer sex only contains L or P!");
        }
    }

    public void validateMaxLimit(Integer max_limit_pinjaman) throws ClientException {
        if (max_limit_pinjaman <= 1000000 && max_limit_pinjaman >= 3000000) {
            throw new ClientException("Customer limit are not allowed!");
        }
    }

    public void validateRecStatus(String id, String recStatus) throws ClientException {
        if (recStatus.equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE)) {
            throw new ClientException("Customer with id = " + id + "is already been deleted");
        }
    }
}
