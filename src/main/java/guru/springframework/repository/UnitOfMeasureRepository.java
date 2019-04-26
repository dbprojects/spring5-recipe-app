/**
 * 
 */
package guru.springframework.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;

/**
 * @author wcsadmin
 *
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	
	Optional<UnitOfMeasure> findByDescription(String description);

}
