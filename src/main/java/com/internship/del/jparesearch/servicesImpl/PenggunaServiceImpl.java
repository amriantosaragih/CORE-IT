package com.internship.del.jparesearch.servicesImpl;

import com.internship.del.jparesearch.Repositories.PenggunaRepository;
import com.internship.del.jparesearch.model.Pengguna;
import com.internship.del.jparesearch.services.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amrianto on 21/06/2017.
 */
@Service
public class PenggunaServiceImpl implements PenggunaService{

    @Autowired
    private PenggunaRepository penggunaRepository;

    @Override
    @Transactional
    public Pengguna savePengguna(Pengguna pengguna) {
        return penggunaRepository.save(pengguna);
    }

    @Override
    @Transactional
    public Pengguna updatePengguna(Pengguna pengguna) {
        Pengguna updatePengguna = findOne(pengguna.getUser_id());
        updatePengguna.setUsername(pengguna.getUsername());
        updatePengguna.setFirst_name(pengguna.getFirst_name());
        updatePengguna.setLast_name(pengguna.getLast_name());
        updatePengguna.setGender(pengguna.getGender());
        updatePengguna.setPassword(pengguna.getPassword());
        updatePengguna.setStatus(pengguna.getStatus());
        return penggunaRepository.saveAndFlush(updatePengguna);
    }

    @Override
    @Transactional
    public Pengguna delete(int id) {
        Pengguna pengguna = findOne(id);
        if(pengguna!=null){
            penggunaRepository.delete(pengguna);
            return pengguna;
        }else {
            return null;
        }
    }

    @Override
    public List<Pengguna> getAllPengguna() {
        int i=0;
        List<Pengguna> pengguna1 = new ArrayList<>();
        List<Pengguna> penggunas = penggunaRepository.findAll();
        for (Pengguna pengguna : penggunas){
            i++;
            if(i<100){
                pengguna1.add(pengguna);
            }
        }
        return pengguna1;
    }

    @Override
    public Pengguna findOne(int id) {
        return penggunaRepository.findOne(id);
    }
}
