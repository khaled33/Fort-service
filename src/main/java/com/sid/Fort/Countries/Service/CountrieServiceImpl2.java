package com.sid.Fort.Countries.Service;

import com.sid.Fort.Countries.Dao.Countrie;
import com.sid.Fort.Countries.Dao.CountrieRepository;
import com.sid.Fort.config.URL_Image.URL_image;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Qualifier("ImpV2")
public class CountrieServiceImpl2 implements ICountrieService {

    @Autowired
    CountrieRepository countrieRepository;

    @Override
    public Countrie getCountrieById(Long id) {
        try {
            return countrieRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }

    }

    @Override
    public List<Countrie> getAllCountries() {
        return countrieRepository.findAll();
    }

    @Override
    public Countrie UpdateCountrie(Countrie countrie, Long id) {
        countrie.setId(id);
        return countrieRepository.save(countrie);
    }

    @Override
    public void DeleteCountrie(Long id) {
        Countrie countrie = countrieRepository.findById(id).get();
        String BaseUrel=URL_image.Path_image_Produit+countrie.getFlag();
        deleteFile(BaseUrel);
        countrieRepository.deleteById(id);
    }

    @Override
    public Countrie AddCountrie(Countrie countrie) {
        return countrieRepository.save(countrie);
    }

    @Override
    public Countrie UpdateCountrie(String country_code, String country_name, Long id, MultipartFile file) {

        Countrie countrie = countrieRepository.findById(id).get();
        countrie.setCountry_name(country_name);
        countrie.setCountry_code(country_code);


        if (file != null) {

            String nom_image = file.getOriginalFilename();
            String extension_image = nom_image.substring(nom_image.indexOf("."));

            String BaseUrel=URL_image.Path_image_Produit+countrie.getFlag();

            deleteFile(BaseUrel);
            AddFile(id, extension_image, file);
            countrie.setFlag(id + extension_image);

            return countrieRepository.save(countrie);

        } else {
            return countrieRepository.save(countrie);

        }

    }

    @Override
    public Countrie AddCountrie(String country_code, String country_name, MultipartFile file) {
        String nom_image = file.getOriginalFilename();
        String extension_image = nom_image.substring(nom_image.indexOf("."));

        Countrie countrie = new Countrie();
        countrie.setCountry_name(country_name);
        countrie.setCountry_code(country_code);
        countrie.setFlag(country_name + extension_image);

        if (countrieRepository.save(countrie).getId() != null) {

            Long id_countrie = countrieRepository.save(countrie).getId();
            countrie.setId(id_countrie);
            countrie.setFlag("" + id_countrie + extension_image);
            AddFile(id_countrie, extension_image, file);

            return countrieRepository.save(countrie);
        }
        return null;
    }

    private void AddFile(Long id_countrie, String extension_image, MultipartFile file) {
        try {
            File convertFile = new File(URL_image.Path_image_Produit + id_countrie + extension_image);
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFile(String BaseUrl){

        File file = new File(BaseUrl);
            try {
                if(file.delete())
                {
                    System.out.println("File deleted successfully");
                }
                else
                {
                    System.out.println("Failed to delete the file");
                }

            }catch (Exception e)
            {
                e.getMessage();
            }
    }

}
