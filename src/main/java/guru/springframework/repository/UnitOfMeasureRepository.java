/**
 * 
 */
package guru.springframework.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;

/**
 * @author wcsadmin
 *
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

}
