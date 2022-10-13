package com.example.retos345.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos345.entities.Ortopedic;
import com.example.retos345.repositories.OrtopedicRepository;


@Service
public class OrtopedicService {
    
        @Autowired
        private OrtopedicRepository ortopedicRepository;

        public OrtopedicService(OrtopedicRepository ortopedicRepository) {
            this.ortopedicRepository = ortopedicRepository;
        }

        // METODOS CRUD
        public List<Ortopedic> getListOrtopedics(){
            return this.ortopedicRepository.findAll();
        }

        public Ortopedic getOrtopedic(int id){
            if(!this.ortopedicRepository.findById(id).isEmpty()){
                return this.ortopedicRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Ortopedic crearOrtopedic(Ortopedic ortopedic){
            return this.ortopedicRepository.save(ortopedic);
        }

        public void eliminarOrtopedic(int id){
            if(!this.ortopedicRepository.findById(id).isEmpty()){
                this.ortopedicRepository.deleteById(id);
            }
        }

        public void actualizarOrtopedic(int id, Ortopedic ortopedic){
            if(!this.ortopedicRepository.findById(id).isEmpty()){
                Ortopedic ortopedicDB = this.ortopedicRepository.findById(id).get();

                this.ortopedicRepository.save(ortopedicDB);
            }
        }
}