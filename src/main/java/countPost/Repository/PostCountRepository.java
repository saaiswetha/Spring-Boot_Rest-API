package countPost.Repository;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import countPost.Model.Employee;
import countPost.Model.PostCount;

public interface PostCountRepository extends MongoRepository<PostCount,ObjectId>{
	
	// returns all the data in count collection in the type of class=PostCount
	@Query(value="{}")
	public PostCount find();
	
}
