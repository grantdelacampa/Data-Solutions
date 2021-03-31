package com.myproject.datasolutions.assets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssetService {

	//Inject an instance of AssetRepository
	@Autowired
	private AssetRepository repo;
	
	// Inherited from JPARepository
	public List<Asset> listAll(){
		return repo.findAll();
	}
	
	// Inherited from JPARepository
	public void save(Asset ast) {
		repo.save(ast);
	}
	
	// Inherited from JPARepository
	public Asset get(int id) {
		return repo.findById(id).get();
	}
	
	// Inherited from JPARepository
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	// Inherited from CRUDRepository
	public int countStatus(String s) {
		return repo.countByStatus(s);
	}
	
	public int countType(String s) {
		return repo.countByType(s);
	}
}
