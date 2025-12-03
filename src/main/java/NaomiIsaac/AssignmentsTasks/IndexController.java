package NaomiIsaac.AssignmentsTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

    @Autowired
    private AssignmentRepository assrepo;


    @GetMapping("/")
    public String Index(){
        return "index";
    }

    @GetMapping("/add")
    public String addAssignmentPage() {
        return "index";
    }

    @PostMapping("/assignmentsuccess")
    public String addtask(@ModelAttribute Assignment assignment, Model model){
        System.out.println(assignment.toString());
        Assignment assignment_added = assrepo.save(assignment);
        model.addAttribute("message", "Your assignment " + assignment_added.getAname() + " was added to the list");
        return "assignmentsuccess";
    }
    
}
