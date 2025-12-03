package NaomiIsaac.AssignmentsTasks;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {

   // List<Assignment> findAllByOrderByPriorityDesc();
   // List<Assignment> findAllByOrderByPriorityAsc();

    List<Assignment> findAllByOrderByDdateAsc();
    List<Assignment> findAllByOrderByDdateDesc();
}