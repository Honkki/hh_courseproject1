package fi.violethonkanen.zooanimals.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.violethonkanen.zooanimals.domain.Animal;
import fi.violethonkanen.zooanimals.domain.AnimalRepository;


//Annotaatio kertoo että kyseessä on controller-luokka
@Controller
public class AnimalController {
	
	//autowired vie repositoryn controller-luokkaan
	@Autowired
	private AnimalRepository repository;
	
	//request-mapping kertoo mikä endpoint palauttaa return arvon
	@RequestMapping("/zoolist")
	public String animalList(Model model) {
		//nimi, arvo
		model.addAttribute("animals", repository.findAll());
		//templaten nimi, joka palautetaan:
		return "zoolist";
		
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	//kerrotaan mikä on pathvariable ylläolevalle requestmappingille
	public String deleteAnimal(@PathVariable("id") Long animalId, Model model) {
		repository.deleteById(animalId);
		return "redirect:../zoolist";
	}
	
	@RequestMapping(value = "/add")
	public String addAnimal(Model model) {
		model.addAttribute("animal", new Animal());
		return "addanimal";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Animal animal) {
		repository.save(animal);
		return "redirect:zoolist";
	}
}
