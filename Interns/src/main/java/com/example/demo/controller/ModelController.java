package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ModelRepo;
import com.example.demo.model.Model;

@RestController
public class ModelController {
	
	@Autowired
	ModelRepo repo;
	Model model;
	@RequestMapping("/")
public String home()
{
		return "home.jsp";
		}
	
		@DeleteMapping("/model/{id}")
	public String deleteModel(@PathVariable String id)
{
	Model a = repo.getOne(id);
	repo.delete(a);
	return "deleted";
	}

	
	
@PostMapping(path="/model", consumes= {"application/json"})
public Model addModel(@RequestBody Model model)
    {
	repo.save(model);
	return model;
	}

@GetMapping(path="/models")
@ResponseBody
public List<Model> getModels()
{
	return repo.findAll();
}

@PutMapping(path="/model", consumes= {"application/json"})
public Model saveOrUpdateModel(@RequestBody Model model)
{
	repo.save(model);
	return model;
	}

@GetMapping("/model/{id}")
@ResponseBody
public Optional<Model> getModel(@PathVariable("id") String id)
{
	return repo.findById(id);

	}



}
