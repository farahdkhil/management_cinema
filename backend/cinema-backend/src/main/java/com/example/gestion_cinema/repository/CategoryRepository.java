package com.example.gestion_cinema.repository;

import com.example.gestion_cinema.entity.filmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<filmCategory,Long> {
    @Query("select c from filmCategory  c ")
    List<filmCategory> findAllCategory();

    @Query("select c from filmCategory c where c.categoryName like %:name%")
    filmCategory findByName (String name);
}
