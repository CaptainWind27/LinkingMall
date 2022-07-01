package com.youko.customerfrontstage.dto.commodity;

import lombok.Data;

import java.util.List;

@Data
public class SpecValueDto {
    String spec;
    List<String> values;
}
