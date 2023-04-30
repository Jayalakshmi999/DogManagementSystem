package com.example.DogManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.DogManagementSystem.models.Dog;
import com.example.DogManagementSystem.models.Trainer;
import com.example.DogManagementSystem.repository.DogRepository;
import com.example.DogManagementSystem.repository.TrainerRepository;

/*
 * @author Jaya Lakshmi Medikonda
 */

@Controller
public class DogController {
//	@RequestMapping("doghome")
//	public String home()
//	{
//		return "home";
//	}
	
	
	ModelAndView mv= new ModelAndView();
	
	@Autowired
	DogRepository repo;
	@Autowired
	TrainerRepository trainerrepo;
	
	@RequestMapping("doghome")
	public ModelAndView home()
	{
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("add")
	public ModelAndView addDog() {
		mv.setViewName("addNewDog");
		Iterable<Trainer> trainer = trainerrepo.findAll();
		mv.addObject("trainers", trainer);
		return mv;
		
	}
	
	@RequestMapping("addNewDog")
	public ModelAndView addNewDog(Dog d,@RequestParam("trainerId") int id)
	{
		
		Trainer train = trainerrepo.findById(id).orElse(new Trainer());
		d.setTrainer(train);
		repo.save(d);
		mv.setViewName("home");
		
		
		
		
		return mv;
	}
	
	@RequestMapping("viewModifyDelete")
	public ModelAndView viewDog()
	{
		mv.setViewName("viewDogs");
		Iterable<Dog> dogList = repo.findAll();
		mv.addObject("dogs",dogList);
		return mv;
	}
	
	@RequestMapping("editDog")
	public ModelAndView editDog(Dog d)
	{
		mv.setViewName("editDog");
		repo.save(d);
		return mv;
		
	}
	
	@RequestMapping("deleteDog")
	public ModelAndView deletedog(Dog d)
	{
//		Optional<Dog> dog = repo.findById(d.getId());
//		if(dog.isPresent())
//		{
//			repo.delete(d);
//		}
//		return home();
		
		
		 //delete by name
//		List<Dog> dog = repo.findByName(d.getName());
//		
//		for(Dog di:dog)
//		{
//			repo.delete(di);
//		}
//		return home()

		Dog dog = repo.findById(d.getId()).orElse(new Dog());
		repo.delete(dog);
		return home();
	}
	
	@RequestMapping("search")
	public ModelAndView searchById(int id)
	{
		Dog d = repo.findById(id).orElse(new Dog());
		mv.addObject(d);
		mv.setViewName("searchResults");
		return mv;
	}
	
	@RequestMapping("addTrainer")
	public ModelAndView addTrainer() {
		mv.setViewName("addNewTrainer");
		return mv;
	}
	
	@RequestMapping("trainerAdded")
	public ModelAndView addTrainerData(Trainer t)
	{
		trainerrepo.save(t);
		mv.setViewName("home");
		return mv;
	}
	
	
	
	
//	
//	

}
