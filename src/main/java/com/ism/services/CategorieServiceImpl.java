package com.ism.services;

import com.ism.entities.Categorie;
import com.ism.repositories.ITables;
import java.util.ArrayList;

public class CategorieServiceImpl implements CategorieService {

    //Couplage fort
    //private TableCategories categoriesRepository=new TableCategories();
    //private CategorieRepository categoriesRepository=new CategorieRepository();

    //Couplage faible
    private ITables<Categorie> categoriesRepository;
    //Injection de dépendance via le constructeur
    public CategorieServiceImpl(ITables<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }
    //Injection de dépendance via le setter
    public void setCategoriesRepository(ITables<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public int add(Categorie categorie) {
        return categoriesRepository.insert(categorie);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        // TODO Auto-generated method stub
        return categoriesRepository.findAll();
    }

    @Override
    public int update(Categorie data) {
        return categoriesRepository.update(data);
    }

    @Override
    public Categorie show(int id) {
        return categoriesRepository.findByID(id);
    }

    @Override
    public int remove(int id) {
        return categoriesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        return categoriesRepository.remove(ids); //new int[0];
    }

}
