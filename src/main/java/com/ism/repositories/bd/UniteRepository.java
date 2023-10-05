package com.ism.repositories.bd;

import com.ism.entities.AbstractEntity;
import com.ism.entities.Unite;
import com.ism.repositories.ITables;

import java.util.ArrayList;

public class UniteRepository implements ITables {

    @Override
    public int insert(AbstractEntity data) {
        return 0;
    }

    @Override
    public int update(AbstractEntity data) {
        return 0;
    }

    @Override
    public ArrayList findAll() {
        return null;
    }

    @Override
    public AbstractEntity findByID(int id) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int indexOf(int id) {
        return 0;
    }

    @Override
    public int[] remove(int[] ids) {
        return new int[0];
    }
}
