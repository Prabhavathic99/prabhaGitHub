package net.javaguides.ems_backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    private LocalDateTime timStamp;
    private String message;
    private String path;
    private String errorCode;

}
