package br.com.portoseguro.products.resource.standard;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
        private LocalDateTime date;
        private String message;
        private String detail;
        private ResponseType responseType;
        private Integer codeStatus;
        private String reasonPhraseStatus;
        private Object data;
}