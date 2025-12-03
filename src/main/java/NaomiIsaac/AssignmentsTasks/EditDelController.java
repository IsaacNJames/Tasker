package NaomiIsaac.AssignmentsTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditDelController {
    @Autowired
    AssignmentRepository assrepo;

    @GetMapping("/edit/{primaryKey}")
    public String showEditForm(@PathVariable Integer primaryKey, Model model){
        Assignment assignment = assrepo.findById(primaryKey).orElseThrow(() -> new IllegalArgumentException("primaryKey: " + primaryKey + " not found")); // Will not compile without elsethrow
        model.addAttribute("myassignment", assignment);

        return "update-assignment";
    }

    @GetMapping("/delete/{primaryKey}")
    public String deleteAssignment(@PathVariable Integer primaryKey) {
        assrepo.deleteById(primaryKey);
        return "redirect:/assignmentlist";
    }

    @GetMapping("/complete/{primaryKey}")
    public String completeAssignment(@PathVariable Integer primaryKey) {

        Assignment assignment = assrepo.findById(primaryKey).orElseThrow(() -> new IllegalArgumentException("Invalid assignment id: " + primaryKey));

        assignment.setCompleted(true); //mark as completed
        assrepo.save(assignment); //save changes

        return "redirect:/assignmentlist";
    }

    @GetMapping("/uncomplete/{primaryKey}")
    public String uncompleteAssignment(@PathVariable Integer primaryKey) {

        Assignment assignment = assrepo.findById(primaryKey).orElseThrow(() -> new IllegalArgumentException("Invalid id: " + primaryKey));

        assignment.setCompleted(false);
        assrepo.save(assignment);

        return "redirect:/assignmentlist";
    }
}
