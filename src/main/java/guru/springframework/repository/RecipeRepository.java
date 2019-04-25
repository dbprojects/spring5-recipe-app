/**
 * 
 */
package guru.springframework.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Recipe;

/**
 * @author wcsadmin
 *
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
