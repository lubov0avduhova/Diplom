package diplom.repository;

import diplom.model.Gifts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GiftsRepository extends CrudRepository<Gifts,Long> {

}
