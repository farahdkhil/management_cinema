package com.example.gestion_cinema.controller;

import com.example.gestion_cinema.entity.filmCategory;
import com.example.gestion_cinema.repository.CategoryRepository;
import com.example.gestion_cinema.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/category1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("/find-all")
    public List<filmCategory> findAll() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        return categoryRepo.findAllCategory() ;   }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }

    @PostMapping("/add")
    public filmCategory save(@RequestBody filmCategory category){
        return categoryService.save(category);
    }


}