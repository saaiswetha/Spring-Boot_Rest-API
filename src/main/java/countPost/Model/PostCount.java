package countPost.Model;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection="count")
public class PostCount {

	@Id
	private ObjectId _id;
	private int post_count;
	
	@LastModifiedBy
	private List<Employee> e;
	@LastModifiedDate
	private List<Date> lastModifiedOn;
	
	public PostCount() {}
	
	public PostCount(int post_count) {this.post_count=post_count;}
	
	public PostCount(ObjectId _id, int post_count) {
		super();
		this._id = _id;
		this.post_count = post_count;
	}
	
	public PostCount(List<Employee> e, List<Date> lastModifiedOn) {
		super();
		this.e = e;
		this.lastModifiedOn = lastModifiedOn;
	}

	public PostCount(ObjectId _id, int post_count, List<Employee> e, List<Date> lastModifiedOn) {
		super();
		this._id = _id;
		this.post_count = post_count;
		this.e = e;
		this.lastModifiedOn = lastModifiedOn;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public int getPost_count() {
		return post_count;
	}

	public void setPost_count(int post_count) {
		this.post_count = post_count;
	}

	public List<Employee> getE() {
		return e;
	}

	public void setE(List<Employee> e) {
		this.e = e;
	}

	public List<Date> getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(List<Date> lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
}
