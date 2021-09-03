package com.porto.logistica.exception;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class LogisticaExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Erro> erros = criarListaErros(ex.getBindingResult());
        return handleExceptionInternal(ex, erros, headers,HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler(NumeroConteinerInvalidoException.class)
    public ResponseEntity<Object> handleNumeroConteinerInvalidoException(NumeroConteinerInvalidoException ex, WebRequest request){
        String mensagemAoUsuario = ex.getMessage();
        List<Erro> erros = Arrays.asList(new Erro(mensagemAoUsuario));
        return  handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
        String mensagemAoUsuario = ex.getMessage();
        List<Erro> erros = Arrays.asList(new Erro(mensagemAoUsuario));
        return  handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler(NumeroConteinerJaExisteException.class)
    public ResponseEntity<Object> handleNumeroConteinerJaExisteException(NumeroConteinerJaExisteException ex, WebRequest request){
        String mensagemAoUsuario = ex.getMessage();
        List<Erro> erros = Arrays.asList(new Erro(mensagemAoUsuario));
        return  handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }



    private List<Erro> criarListaErros(BindingResult bindingResult) {
        List<Erro> erros = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String mensagemAoUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            erros.add(new Erro(mensagemAoUsuario));
        }
        return  erros;
    }

    @Getter
    public class Erro{
        String mensagemAoUsuario;
        public Erro(String mensagemAoUsuario) {
            this.mensagemAoUsuario = mensagemAoUsuario;
        }
    }
}
