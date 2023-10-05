package com.capture.cron.repositories;

import com.capture.cron.entities.LandingPages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 랜딩 페이지를 관리하기 위한 레포지토리 클래스
public interface LandingPageRepository extends JpaRepository<LandingPages,Long> {
}
