package com.example.gestion_cinema.serviceImpl;

import com.example.gestion_cinema.entity.filmCategory;
import com.example.gestion_cinema.repository.CategoryRepository;
import com.example.gestion_cinema.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;


    @Override
    public filmCategory add(filmCategory category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<filmCategory> findAll() {
        return categoryRepo.findAllCategory();
    }

    @Override
    public filmCategory save(filmCategory category) {
        if (category.getCategoryName() == null) {
            //throw new InvalidEntityException("Nom catégorie invalide");
        }
        filmCategory c = categoryRepo.findByName(category.getCategoryName());
        if (c != null) {
            //throw new InvalidEntityException("catégorie existe déja !");
        }
        return categoryRepo.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}