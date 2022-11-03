package br.com.dbcompany.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class TagDTO {
    private String id;
    private String name;
}
