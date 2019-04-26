/**
 * 
 */
package guru.springframework.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;
import guru.springframework.repository.RecipeRepository;

/**
 * @author wcsadmin
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	
	
	
	public RecipeServiceImpl(guru.springframework.repository.RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}



	@Override
	public Set<Recipe> getRecipes() {
		// TODO Auto-generated method stub
		Set<Recipe> recipeSet = new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);		
		return recipeSet;
	}
	
}
