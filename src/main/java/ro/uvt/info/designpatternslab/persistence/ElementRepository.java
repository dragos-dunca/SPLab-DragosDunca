package ro.uvt.info.designpatternslab.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.info.designpatternslab.models.BaseElementEntity;

@Repository
public interface ElementRepository extends JpaRepository<BaseElementEntity, Integer> {
}