package com.example.dao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dao.entity.LiteratureNew;

public interface LiteratureRepository extends JpaRepository<LiteratureNew, Integer> {

}
