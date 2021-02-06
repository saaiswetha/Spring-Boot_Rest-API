package countPost.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import countPost.Model.Employee;
import countPost.Model.PostCount;
import countPost.Repository.PostCountRepository;

@RestController
public class PostCountControllers {

	@Autowired
	private PostCountRepository repository;	
		

}
