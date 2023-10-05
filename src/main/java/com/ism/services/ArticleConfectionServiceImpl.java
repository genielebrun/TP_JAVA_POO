package com.ism.services;
import com.ism.entities.ArticleConfection;
import com.ism.repositories.ITables;
import java.util.ArrayList;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {


    //Couplage faible
    private ITables<ArticleConfection> articleConfectionsRepository;
    //Injection de dépendance via le constructeur
    public ArticleConfectionServiceImpl(ITables<ArticleConfection> articleConfectionsRepository) {
        this.articleConfectionsRepository = articleConfectionsRepository;
    }
    //Injection de dépendance via le setter
    public void setarticleConfectionsRepository(ITables<ArticleConfection> articleConfectionsRepository) {
        this.articleConfectionsRepository = articleConfectionsRepository;
    }

    @Override
    public int add(ArticleConfection articleConfection) {
        return articleConfectionsRepository.insert(articleConfection);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {

        return articleConfectionsRepository.findAll();
    }

    @Override
    public int update(ArticleConfection data) {
        return articleConfectionsRepository.update(data);
    }

    @Override
    public ArticleConfection show(int id) {
        return articleConfectionsRepository.findByID(id);
    }

    @Override
    public int remove(int id) {
        return articleConfectionsRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        return articleConfectionsRepository.remove(ids);
    }
}
