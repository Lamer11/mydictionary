package mydiction.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class Mydictionary2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date createdAt;
	private String word;
	
	public Mydictionary2() {} // JPA не дает создавать сущности без конструктора по умолчанию
	
	public Mydictionary2(Long id, String word) {
		this.id = id;
		this.word = word;
	}
	
	
	@PrePersist // Данный метод сохраняет текущее дата_время в переменную createdAt перед сохранением записи.
	 void createdAt() {
		this.createdAt = new Date();
	 }

}
