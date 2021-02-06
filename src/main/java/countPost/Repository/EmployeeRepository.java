package countPost.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import countPost.Model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,ObjectId> {

	@Query(value="{}", count =true)
	public int Count();

	
}
