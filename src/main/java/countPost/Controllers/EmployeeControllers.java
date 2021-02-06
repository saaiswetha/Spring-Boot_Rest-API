// whenever post api is called/hit we need to count the number of times this post api is hit 
//i.e we must increment every time a post is done. -->db name=employee, 2 collections - details and count, employee stores the emp details and count stores the post_count number.
//every time a new employee is posted, we must increment count var --> so we get the count , update hte 


package countPost.Controllers;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import countPost.Model.Employee;
import countPost.Model.PostCount;
import countPost.Repository.EmployeeRepository;
import countPost.Repository.PostCountRepository;

@RestController
public class EmployeeControllers  {

	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private PostCountRepository repository2;
		
	//----------------------------------------------POST API---------------------------------------------------------	
	
	/*
	 * to post employee details and increment the count= number of times POST API
	 * is hit
	 */	
	@PostMapping("/post")
	public String createEmp(@RequestBody Employee e) {
		try {
			repository.save(e);
			System.out.println("added employee "+e.getName());
			updateCount();	                                       //updates the post_count field in collection count
			
		}catch(Exception exp) {
			System.out.println(exp);
		}
		return "added new employee "+e.getName();
	}
	
	// get API for count
	
	@GetMapping("/getpostcount")
	public int getCount() {
		return repository2.find().getPost_count();	
	}
	
	//another get API for count
	
	@GetMapping("/getPostCount")
	public int Count()
	{
		return repository.Count();
	}
	
	//function to retrieve count, increment it and return the incremented count
	
	public PostCount updateCount() {        //get the post_count var, increment it nd update it, then save it.
			
			int c=getCount();
			PostCount pc=findAll();
			c=c+1;
			pc.setPost_count(c);
			repository2.save(pc);
			return pc;		
	}	
	
	public PostCount findAll() {
		return repository2.find();
	}
	
	//--------------------------------------------------UPDATE-------------------------------------------------------------
	
	/*
	 * API to update employee details and store the details like modifiedDate and lastModifiedBy
	 */	
	
	@PutMapping("updateEmp")
	public String updateDetails(@RequestBody Employee e,@RequestParam ObjectId _id) {  //_id eg = 601909c0bdc75d218805d2b6
		
		try {
			e.set_id(_id);
			repository.save(e);
			modifiedDetails(e);
			System.out.println("added updated details to count collection");
			
		}catch(Exception exp) {
			System.out.println(exp);
		}
		return "updated emp "+e.getName();		
	}
	
	/*
	 * function to save modified date and lastModifiedBy
	 */	
	  public void modifiedDetails(Employee emp) { 
		 
			  PostCount pc2 = repository2.find();	  
				 java.util.Date date=new java.util.Date(); 
				 
				 //pc2.setE(emp);pc2.setLastModifiedOn(date);
				 
				 pc2.setE(insertModifiedBy(pc2,emp));
				 pc2.setLastModifiedOn(insertCurrentDate(date,pc2));
		  
			     repository2.save(pc2); 
			     System.out.println("added modified details");
	  }

		/*
		 * function to return lastModifiedBy
		 */	  
	  
	public List<Employee> insertModifiedBy(PostCount pc,Employee e) {
		List<Employee> emp=pc.getE();	
		emp.add(e);
		return emp;
	}
	
	/*
	 * function to return modified date
	 */	  
  
	
	public List<Date> insertCurrentDate(Date d,PostCount pc) {
		List<Date> date=pc.getLastModifiedOn();
		date.add(d);
		return date;
	}
	
	//GET API to retrieve details from count and employee collection
	
	@GetMapping("/findallemp")
	public List<Employee> getDEtails(){
		return repository.findAll();
	}
	
	@GetMapping("/getModifiedDetails")
	public List<PostCount> findDetails(){
		return repository2.findAll();
	}
}
