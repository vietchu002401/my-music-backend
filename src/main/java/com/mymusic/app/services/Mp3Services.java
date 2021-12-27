package com.mymusic.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mymusic.app.model.Mp3Model;
import com.mymusic.app.model.ResponseMp3Model;
import com.mymusic.app.repositories.Mp3Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Mp3Services {
    @Autowired
    Mp3Repository mp3Repository;

    public ResponseEntity<ResponseMp3Model> getAllList(){
        try {
            List<Mp3Model> found = mp3Repository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMp3Model(true, "success", found));
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ResponseMp3Model> getById(String id){
        try {
            Optional<Mp3Model> found = mp3Repository.findById(id);
            List<Mp3Model> data = new ArrayList<>();
            data.add(found.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMp3Model(true, "success", data));
        } catch (Exception e) {
            throw e;
        }
    }

    // public ResponseEntity<ResponseMp3Model> updateContent(Object req, String id, String location){
    //     try {
    //         int locat = Integer.parseInt(location);
    //         Optional<Mp3Model> found = mp3Repository.findById(id);
    //         Object[] list = found.get().getList().toArray();
    //         list[locat] = req;
    //         found.get().setList(Arrays.asList(list));
    //         List<Mp3Model> data = new ArrayList<>();
    //         data.add(found.get());
    //         return ResponseEntity.status(HttpStatus.OK).body(new ResponseMp3Model(true, "success", data));
    //     } catch (Exception e) {
    //         throw e;
    //     }
    // }
}
