package com.B305.ogym.exception;

import static com.B305.ogym.common.util.constants.ResponseConstants.DUPLICATION_EMAIL;
import static com.B305.ogym.common.util.constants.ResponseConstants.DUPLICATION_NICKNAME;
import static com.B305.ogym.common.util.constants.ResponseConstants.NOT_VALID_PARAM;
import static com.B305.ogym.common.util.constants.ResponseConstants.USER_NOT_FOUND;
import static com.B305.ogym.common.util.constants.ResponseConstants.VALIDATION_FAILED;

import com.B305.ogym.exception.user.NotValidRequestParamException;
import com.B305.ogym.exception.user.UserDuplicateEmailException;
import com.B305.ogym.exception.user.UserDuplicateException;
import com.B305.ogym.exception.user.UserDuplicateNicknameException;
import com.B305.ogym.exception.user.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Valid 조건을 만족하지 못한 요청에 대한 에러 핸들러
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
        WebRequest request) {

//        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
//            .message("Vaildation Failed")
////            .Error(ex.getBindingResult().toString())
//            .Error(ex.getMessage())
//            .build();
//        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

        log.debug("Vaildation failed", ex);
        return VALIDATION_FAILED;
    }

//    // 이미 존재하는 유저 가입에 대한 에러 핸들러
//    @ExceptionHandler(UserDuplicateException.class)
//    public final ResponseEntity<String> handleUserDuplicateException(UserDuplicateException ex) {
//        log.debug("중복 유저", ex);
//        return DUPLICATION_USER;
//    }

    // 이미 존재하는 Email 가입에 대한 에러 핸들러
    @ExceptionHandler(UserDuplicateEmailException.class)
    public final ResponseEntity<String> handleUserDuplicateEmailException(UserDuplicateEmailException ex) {
        log.debug("중복 Email", ex);
        return DUPLICATION_EMAIL;
    }
    // 이미 존재하는 Nickname 가입에 대한 에러 핸들러
    @ExceptionHandler(UserDuplicateNicknameException.class)
    public final ResponseEntity<String> handleUserDuplicateNicknameException(UserDuplicateNicknameException ex) {
        log.debug("중복 Nickname", ex);
        return DUPLICATION_NICKNAME;
    }

    // 존재하지 않는 유저 정보 조회에 대한 에러 핸들러
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        log.debug("존재하지 않는 유저", ex);
        return USER_NOT_FOUND;
    }

    // 입력해야하는 파라미터 중에 입력하지 않은 파라미터가 존재하는 경우
    @ExceptionHandler(NotValidRequestParamException.class)
    public final ResponseEntity<String> handleNotValidRequestParamException(NotValidRequestParamException ex) {
        log.debug("입력하지 않은 파라미터 존재", ex);
        return NOT_VALID_PARAM;
    }

    // 5xx error handler : 서버에서 발생한 전반적인 에러에 대한 핸들러
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
            .Error(request.getDescription(false))
            .message(ex.getMessage())
            .build();
        log.debug("server error", ex);
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}