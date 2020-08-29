package me.louwrens.spring.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.louwrens.spring.hibernate.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
