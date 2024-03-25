package diplom.repository;

import diplom.model.UsersSex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersSexRepository extends CrudRepository<UsersSex,Long> {

}
