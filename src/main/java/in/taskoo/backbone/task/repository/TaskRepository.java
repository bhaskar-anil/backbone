package in.taskoo.backbone.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.taskoo.backbone.task.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
  @Query("  SELECT t from TaskEntity t WHERE "
      + "             (:query is null OR (t.title LIKE %:query% OR t.details LIKE %:query%)) "
      + "      AND    (:loc IS null OR t.locationEntity.name LIKE %:loc%) "
      + "      AND    (:maxp IS null OR t.budgetAmount <= :maxp) "
      + "      AND    (:minp IS null OR t.budgetAmount >= :minp) "
      + "      AND    (:taskType IS null OR t.taskType = :taskType) "
      + "      AND    (:status IS null OR t.status LIKE :status) ")
  public List<TaskEntity> search(@Param("query") String query, @Param("loc") String loc, 
      @Param("maxp") Integer maxp, @Param("minp") Integer minp, @Param("taskType") Integer tt,
      @Param("status") Integer ts);
}
