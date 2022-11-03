package br.com.dbcompany.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ResponseDTO {
    private String code;
    private String type;
    private String message;
}
