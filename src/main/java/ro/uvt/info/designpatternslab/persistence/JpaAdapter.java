package ro.uvt.info.designpatternslab.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaAdapter<T, ID> implements CrudRepository<T, ID> {
    private final JpaRepository<T, ID> jpaRepository;

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }
}