package com.capture.cron.services;

import com.capture.cron.common.exceptions.CustomException;
import com.capture.cron.common.exceptions.ErrorCode;
import com.capture.cron.dtos.LandingPageDto;
import com.capture.cron.dtos.LandingPageRequestDto;

import com.capture.cron.entities.LandingPage;
import com.capture.cron.repositories.LandingPageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LandingPageService {

    private final LandingPageRepository repository;


    @Transactional
    public Long postLandingPage(LandingPageRequestDto dto){
        /*
        * 랜딩페이지 등록하는 메서드 - 자동으로 캡쳐는 Y값으로 들어감
        * */
        LandingPage page  =dto.toLandingPage(dto);
        try {
            return repository.save(page).getId();
        }catch (Exception e){
            throw new CustomException(ErrorCode.POST_LANDING_FAILED);
        }
    }

    @Transactional
    public Long deleteLandingPage(Long id){
        /*
        * 삭제하는 메서드
        * */
        try{
            repository.deleteById(id);
            return id;
        }catch(Exception e){
            throw new CustomException(ErrorCode.LANDING_NOT_FOUND);
        }
    }

    @Transactional
    public List<LandingPageDto> getLandingPages (){
        /*
        * 페이징은 나중에 구현 예정
        * */
        List<LandingPageDto> dtos = repository
                .findAllLandingPageByIdDesc()
                .stream()
                .map(LandingPageDto::new)
                .toList();
        return dtos;
    }








}
