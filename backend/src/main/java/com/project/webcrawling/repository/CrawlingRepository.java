package com.project.webcrawling.repository;

import com.project.webcrawling.entity.Crawling;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CrawlingRepository extends CrudRepository<Crawling, Long> {
    @Query("SELECT c FROM Crawling c WHERE DATE_FORMAT(c.created_at, '%Y-%m-%d %H:%i') = " +
            "(SELECT MAX(DATE_FORMAT(cc.created_at, '%Y-%m-%d %H:%i')) FROM Crawling cc) ORDER BY c.id DESC")
    List<Crawling> findLatestCrawlings();

    @Query("SELECT c FROM Crawling c WHERE c.created_at >= :startDate AND c.created_at < :endDate ORDER BY c.id DESC")
    List<Crawling> findByCrawlingTimeRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}