package com.capture.cron.repositories;

import com.capture.cron.entities.LandingPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 랜딩 페이지를 관리하기 위한 레포지토리 클래스
public interface LandingPageRepository extends JpaRepository<LandingPage,Long> {

    @Query("SELECT l FROM LandingPage l ORDER BY id DESC")
    List<LandingPage> findAllLandingPageByIdDesc();


    @Query("SELECT l FROM LandingPage l WHERE captureYn = 'Y'")
    List<LandingPage> findLandingPageByCaptureYn();

}
