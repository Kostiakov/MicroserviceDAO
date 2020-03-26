package com.example.dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.dao.LiteratureRepository;
import com.example.dao.entity.BookNew;
import com.example.dao.entity.LiteratureList;
import com.example.dao.entity.LiteratureNew;
import com.example.dao.entity.MagazineNew;

@RestController
@RequestMapping("/bookshop")
public class DaoRestController {
	
	@Autowired
	private LiteratureRepository repository;
	
	@GetMapping("/literature")
	public LiteratureList getAllLiterature(){
		List<LiteratureNew> theLiterature=repository.findAll();
		LiteratureList list = new LiteratureList();
		list.setList(theLiterature);
		return list;
	}
	
	@GetMapping("/literature/{theId}")
	public LiteratureNew getLiterature(@PathVariable("theId")int theId) {
		LiteratureNew theLiterature = repository.getOne(theId);
		return theLiterature;
	}
	
	@PostMapping("/literature/book")
	public LiteratureNew addBook(@RequestBody BookNew theBook) {
		repository.save(theBook);
		return theBook;
	}
	
	@PostMapping("/literature/magazine")
	public LiteratureNew addMagazine(@RequestBody MagazineNew theMagazine) {
		repository.save(theMagazine);
		return theMagazine;
	}
	
	@PutMapping("/literature")
	public LiteratureNew updateLiterature(@RequestBody LiteratureNew theLiterature) {
		repository.save(theLiterature);
		return theLiterature;
	}
	
	@DeleteMapping("/literature/{theId}")
	public void deleteLiterature(@PathVariable("theId") int theId) {
		repository.deleteById(theId);
	}

}
