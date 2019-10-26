package fi.violethonkanen.zooanimals.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//annotaatio kertoo että tämä luokka on entity-luokka
@Entity
public class Animal {
	//annotaatiot kertovat, että tämä on uniikki id ja se tulee automaattisesti tietokannasta
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name, sex;
	private double weight;
	
	//constructor ilman attribuutteja
	public Animal() {}
	
	public Animal(String name, String sex, double weight) {
		super();
		this.name = name;
		this.sex = sex;
		this.weight = weight;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
