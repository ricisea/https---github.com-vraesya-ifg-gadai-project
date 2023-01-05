package co.id.nds.gadai.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.id.nds.gadai.entities.PelangganEntity;
import co.id.nds.gadai.exceptions.ClientException;
import co.id.nds.gadai.exceptions.NotFoundException;
import co.id.nds.gadai.models.PelangganModel;
import co.id.nds.gadai.models.ResponseModel;
import co.id.nds.gadai.services.PelangganService;

@RestController
@RequestMapping("/pelanggan")
public class PelangganController {
    @Autowired
    private PelangganService pelangganService;

    @PostMapping(value = "/doInsertPelanggan")
    public ResponseEntity<ResponseModel> postCustomerController(@RequestBody PelangganModel pelangganModel) {
        try {
            //request
            PelangganEntity pelanggan = pelangganService.add(pelangganModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("New Customer Account is successfully added!");
            response.setDesc("Sukses input data pelanggan baru");
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setData(pelanggan);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }
    
    @GetMapping(value = "/doGetDetailPelanggan")
    public ResponseEntity<ResponseModel> getAllDetailController() {
        try {
            //request
            List<PelangganEntity> pelanggan = pelangganService.getDetailPelanggan();

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Request successfully");
            response.setData(pelanggan);
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setDesc("Detail pelanggan berhasil di tampilkan");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping(value = "/doSearchPelanggan")
    public ResponseEntity<ResponseModel> searchController(@RequestBody PelangganModel pelangganModel){
        try {
            //request
            List<PelangganEntity> pelanggan = pelangganService.searchPelanggan(pelangganModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Request successfully");
            response.setDesc("Daftar pencarian pelanggan berhasil ditampilkan");
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setData(pelanggan);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PutMapping(value = "/doUpdatePelanggan")
    public ResponseEntity<ResponseModel> putPelangganController(@RequestBody PelangganModel pelangganModel){
        try{
            //request
            PelangganEntity pelanggan = pelangganService.update(pelangganModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Account is successfully update");
            response.setDesc("Suksess ubah data pelanggan dengan ID: "+ pelangganModel.getId());
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setData(pelanggan);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        
        } catch (NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        } catch (Exception e) {
             ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @DeleteMapping("/doDeletePelanggan")
    public ResponseEntity<ResponseModel> deletePelangganController(@RequestBody PelangganModel pelangganModel) {
        try {
            //request
            PelangganEntity pelanggan = pelangganService.delete(pelangganModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Account is successfully delete");
            response.setDesc("Sukses hapus data pelanggan "+ pelangganModel.getId());
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setData(pelanggan);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        
        } catch (NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        } catch (Exception e) {
             ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        } 
    }

    @GetMapping("/doGetListJenisUsaha")
    public ResponseEntity<ResponseModel> getAllJnsUsahaController(@RequestBody PelangganModel pelangganModel) {
        try {
            //request
            List<PelangganEntity> pelanggan = pelangganService.getListUsaha(pelangganModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Request successfully");
            response.setDesc("Daftar pencarian Jenis usaha aktif berhasil ditampilkan");
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setData(pelanggan);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

}
