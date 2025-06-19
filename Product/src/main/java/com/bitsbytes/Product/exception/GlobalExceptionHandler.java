package com.bitsbytes.Product.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.bitsbytes.Product.Dto.ExceptionResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(CategoryAlreadyExistsException.class)
        public ResponseEntity<ExceptionResponseDTO> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException ex, 
        WebRequest webRequest){
            ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false), HttpStatus.CONFLICT, 
                ex.getMessage(), LocalDateTime.now()
            );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
        }

        @ExceptionHandler(CategoryNotFoundException.class)
        public ResponseEntity<ExceptionResponseDTO> handleCategoryNotFoundException(CategoryNotFoundException ex, 
        WebRequest webRequest){
            ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false), HttpStatus.NOT_FOUND, 
                ex.getMessage(), LocalDateTime.now()
            );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ExceptionResponseDTO> handleGlobalException(Exception ex, 
        WebRequest webRequest){
            ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, 
                ex.getMessage(), LocalDateTime.now()
            );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
        }
}
