package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.OptionEntity;

public interface OptionEntityRepository  extends JpaRepository<OptionEntity, Long>{

}
