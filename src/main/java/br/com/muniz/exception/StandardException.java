package br.com.muniz.exception;

import java.util.Date;

public record StandardException(Date timeStamp, String message, String details) {
}
