package NaomiIsaac.AssignmentsTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AssignmentListController {
    @Autowired
    private AssignmentRepository assrepo;

    @PostMapping("/edit/{primaryKey}")
    public String updateAssignment(@PathVariable Integer primaryKey, @Validated Assignment assignment, BindingResult result, Model model) {
        if(result.hasErrors()){
            System.out.println("Assignment Update Error" + assignment.getPrimaryKey());
            return "update-assignment";
        }

        assignment.setPrimaryKey(primaryKey);
        
        assrepo.save(assignment);
        return "redirect:/assignmentlist";
    }

    @GetMapping("/assignmentlist")
    public ModelAndView asslist(@RequestParam(defaultValue = "none") String sort) {
      
        Iterable<Assignment> assignments;

        switch(sort) {
           /*case "priorityHigh":
                assignments = assrepo.findAllByOrderByPriorityDesc();
                break;
            case "priorityLow":
                assignments = assrepo.findAllByOrderByPriorityDesc();
                break;
            */
            case "dueDateAsc":
                assignments = assrepo.findAllByOrderByDdateAsc();
                break;
            case "dueDateDesc":
                assignments = assrepo.findAllByOrderByDdateDesc();
                break;
            default:
                assignments = assrepo.findAll();
        }

        ModelAndView mav = new ModelAndView("assignmentlist");
        mav.addObject("myassignments", assignments);
        mav.addObject("currentSort", sort);
        return mav;
    }

}
