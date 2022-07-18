package jana60.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.Model.Degrees;
import jana60.Model.University;
import jana60.Repository.DegreesRepository;
import jana60.Repository.UniversityRepository;

@Controller
@RequestMapping("/")
public class UniversityController {
	
	@Autowired 
	private UniversityRepository repo;
	@Autowired
	private DegreesRepository repo2;
	
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
	
	@GetMapping("/degrees")
	public String degrees(Model model) {
		List<Degrees> DegreesList = (List<Degrees>)repo2.findAll();
		model.addAttribute("DegreesList" ,DegreesList);
		return "degrees";
	}
	
	@GetMapping("/dipartimenti/{id}")
	public String departmentDetail(Model model, @PathVariable(name = "id") Integer departmentPrimaryKey) {
		University currentDepartment = repo.findById(departmentPrimaryKey).get();
		model.addAttribute("department", currentDepartment);
		System.out.println(currentDepartment.getDegrees().size());
		return "departmentDetail";
	}
}
	
