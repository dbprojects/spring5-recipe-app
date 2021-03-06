/**
 * 
 */
package guru.springframework.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author wcsadmin
 *
 */

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private String prepTime;
	private String cookTime;
	private String servings;
	private String url;
	
	@Lob
	private String directions;
	
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingradient> ingradients = new HashSet<>();
	
	
	@Lob
	private Byte[] image;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;
	
	@ManyToMany
	@JoinTable(name = "recipe_category",
	joinColumns = @JoinColumn(name="recipe_id"),
	inverseJoinColumns = @JoinColumn(name= "category_id")
	)
	private Set<Category> categories = new HashSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}
	public String getCookTime() {
		return cookTime;
	}
	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}
	public String getServings() {
		return servings;
	}
	public void setServings(String servings) {
		this.servings = servings;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
	public Notes getNotes() {
		return notes;
	}
	public void setNotes(Notes notes) {
		this.notes = notes;
		notes.setRecipe(this);
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public Set<Ingradient> getIngradients() {
		return ingradients;
	}
	public void setIngradients(Set<Ingradient> ingradients) {
		this.ingradients = ingradients;
	}
	
	public Recipe addIngradient(Ingradient ingradient) {
		ingradient.setReceipe(this);
		this.ingradients.add(ingradient);
		return this;
		
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
}
