package com.capture.cron.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    // 400 BAD_REQUEST
    // 401 UNAUTHORIZED
    INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "권한 정보가 없는 토큰입니다."),

    // 404 NOT_FOUND
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 정보의 사용자를 찾을 수 없습니다."),

    // 409 : CONFLICT
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "데이터가 이미 존재합니다."),

    // 500 : Invalid ServerError
    // 캡쳐 실패
    CAPTURE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "캡쳐에 실패하였습니다."),
    
    // 500 : Invalid
    // 랜딩페이지 등록에러
    POST_LANDING_FAILED(HttpStatus.INTERNAL_SERVER_ERROR,"랜딩페이지 등록 실패"),

    // 404 : NOT FOUND
    // 랜딩 페이지 없음
    LANDING_NOT_FOUND(HttpStatus.NOT_FOUND,"랜딩 페이지를 찾을 수 없습니다")


    ;


    private final HttpStatus httpStatus;
    private final String message;

}
