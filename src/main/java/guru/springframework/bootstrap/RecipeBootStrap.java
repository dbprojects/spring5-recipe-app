package guru.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingradient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.RecipeRepository;
import guru.springframework.repository.UnitOfMeasureRepository;

@Component
public class RecipeBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	private UnitOfMeasureRepository unitOfMeasureRepository;
	private CategoryRepository categoryRepository;
	private RecipeRepository recipeRepository;
	
	
	
	public RecipeBootStrap(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
		super();
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeRepository.saveAll(getRecipes());
		
	}

	private List<Recipe> getRecipes(){
		
		List<Recipe> recipes = new ArrayList<>(2);
		
		//Get UOMs
		
		Optional<UnitOfMeasure> eachUOMOptional =  unitOfMeasureRepository.findByDescription("Each");
		if(!eachUOMOptional.isPresent() ) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> teaSpoonUOMOptional =  unitOfMeasureRepository.findByDescription("Teaspoon");
		if(!teaSpoonUOMOptional.isPresent() ) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> tableSpoonUOMOptional =  unitOfMeasureRepository.findByDescription("Tablespoon");
		if(!tableSpoonUOMOptional.isPresent() ) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> cupUOMOptional =  unitOfMeasureRepository.findByDescription("Cup");
		if(!cupUOMOptional.isPresent() ) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> pinchUOMOptional =  unitOfMeasureRepository.findByDescription("Pinch");
		if(!pinchUOMOptional.isPresent() ) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> ounceUOMOptional =  unitOfMeasureRepository.findByDescription("Ounce");
		if(!ounceUOMOptional.isPresent() ) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		
		//get Optionals
		
		UnitOfMeasure eachUOM = eachUOMOptional.get();
		UnitOfMeasure tableSpoonUOM = tableSpoonUOMOptional.get();
		UnitOfMeasure teaSpoonUOM = teaSpoonUOMOptional.get();
		UnitOfMeasure cupUOM = cupUOMOptional.get();
		UnitOfMeasure pincUOM = pinchUOMOptional.get();
		UnitOfMeasure ounceUOM = ounceUOMOptional.get();
		
		
		//Get Category
	
		Optional<Category> americanCatOptional =  categoryRepository.findByDescription("American");
		if(!americanCatOptional.isPresent() ) {
			throw new RuntimeException("Expected Category not found");
		}
		
		Optional<Category> italianCatOptional =  categoryRepository.findByDescription("Italian");
		if(!italianCatOptional.isPresent() ) {
			throw new RuntimeException("Expected Category not found");
		}
		
		Optional<Category> mexicanCatOptional =  categoryRepository.findByDescription("Mexican");
		if(!mexicanCatOptional.isPresent() ) {
			throw new RuntimeException("Expected Category not found");
		}
		
		Optional<Category> fastFoodCatOptional =  categoryRepository.findByDescription("Fast Food");
		if(!fastFoodCatOptional.isPresent() ) {
			throw new RuntimeException("Expected Category not found");
		}
		
		Category americanCategory = americanCatOptional.get();
		Category mexicanCategory = mexicanCatOptional.get();
		
		//
		Recipe guacRecipe = new Recipe();
		guacRecipe.setDescription("Perfect Guacamole");
		guacRecipe.setPrepTime("10");
		guacRecipe.setCookTime("10");
		guacRecipe.setDifficulty(Difficulty.HARD);
		
		guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");
		
		
		Notes notes = new Notes();
		notes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
		
		guacRecipe.setNotes(notes);
		notes.setRecipe(guacRecipe);
		
		guacRecipe.getIngradients().add(new Ingradient("ripe avocados", new BigDecimal(2), eachUOM,guacRecipe));
		guacRecipe.getIngradients().add(new Ingradient("Kosher salt", new BigDecimal(5), teaSpoonUOM,guacRecipe));
		guacRecipe.getIngradients().add(new Ingradient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonUOM,guacRecipe));
		guacRecipe.getIngradients().add(new Ingradient("Minced red ionion or thinly sliced green onion", new BigDecimal(2), tableSpoonUOM,guacRecipe));
		guacRecipe.getIngradients().add(new Ingradient("Serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUOM,guacRecipe));
		guacRecipe.getIngradients().add(new Ingradient("Cilantro", new BigDecimal(2), tableSpoonUOM,guacRecipe));
		guacRecipe.getIngradients().add(new Ingradient("freshly grated black pepper", new BigDecimal(2), eachUOM,guacRecipe));
		
		guacRecipe.getCategories().add(mexicanCategory);
		guacRecipe.getCategories().add(americanCategory);
		
		recipes.add(guacRecipe);
		
		
		return recipes;
		
	}



}
