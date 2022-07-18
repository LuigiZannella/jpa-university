package jana60.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jana60.Model.University;


@Repository
public interface UniversityRepository extends CrudRepository <University, Integer> {

	List<University> findAllByOrderByName();
}