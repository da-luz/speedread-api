package com.speedread.api.repositories;

import com.speedread.api.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface SprintRepository extends JpaRepository<Sprint, Long> {

    @Query(nativeQuery = true, value = "SELECT TOP 1 * FROM sprints WHERE sprints.user_id=:userId AND sprints.state='STARTED'")
    Optional<Sprint> findStartedByUserId(Long userId);

    @Query(nativeQuery = true, value = "SELECT SUM(sprints.elapsed_time) FROM sprints WHERE sprints.user_id=:userId")
    Long sumElapsedTimeByUserId(Long userId);

    @Query(nativeQuery = true, value = "SELECT AVG(sprints.elapsed_time) FROM sprints WHERE sprints.user_id=:userId")
    Long averageElapsedTimeByUserId(Long userId);

    @Query(nativeQuery = true, value = "SELECT SUM(sprints.elapsed_time) FROM sprints WHERE sprints.user_id=:userId AND sprints.book_id=:bookId")
    Long sumElapsedTimeByUserIdAndBookId(Long userId, Long bookId);

    @Query(nativeQuery = true, value = "SELECT AVG(sprints.elapsed_time) FROM sprints WHERE sprints.user_id=:userId AND sprints.book_id=:bookId")
    Long averageElapsedTimeByUserIdAndBookId(Long userId, Long bookId);
}
