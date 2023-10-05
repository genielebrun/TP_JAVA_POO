package com.ism.services;
import com.ism.entities.Unite;
import com.ism.repositories.ITables;
import java.util.ArrayList;

public class UniteServiceImpl implements IService<Unite>{

    //Couplage fort


    //Couplage faible
    private ITables<Unite> uniteRepository;
    //Injection de dépendance via le constructeur
    public UniteServiceImpl(ITables<Unite> uniteRepository) {
        this.uniteRepository = uniteRepository;
    }
    //Injection de dépendance via le setter
    public void setUniteRepository(ITables<Unite> uniteRepository) {
        this.uniteRepository = uniteRepository;
    }


    @Override
    public int add(Unite unite) {
        return uniteRepository.insert(unite);
    }

    @Override
    public ArrayList<Unite> getAll() {
        return uniteRepository.findAll();
    }

    @Override
    public int update(Unite data) {
        return uniteRepository.update(data);
    }

    @Override
    public Unite show(int id) {
        return uniteRepository.findByID(id);
    }

    @Override
    public int remove(int id) {
        return uniteRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        return uniteRepository.remove(ids); //new int[0];
    }
}
