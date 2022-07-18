package jana60.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.Model.University;
import jana60.Repository.UniversityRepository;



@Controller
@RequestMapping("/")
public class UniversityController {
	
	@Autowired 
	private UniversityRepository repo;
	
	@GetMapping
	public String fristpage() {
		return "fristpage";
	}

	@GetMapping("/dipartimenti")
	public String home(Model model) {
		List<University> DepartmentsList =(List<University>)repo.findAllByOrderByName();
		model.addAttribute("DepartmentsList" ,DepartmentsList);
		//Per testare la lista vuota
		// model.addAttribute("DepartmentsList" ,new ArrayList<>());
		return "home";
	}
	
}