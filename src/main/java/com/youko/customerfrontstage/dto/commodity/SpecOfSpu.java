package com.youko.customerfrontstage.dto.commodity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpecOfSpu implements Serializable {
    private static final long serialVersionUID = 674027049973857761L;
    String Spec;
    int SpecID;
}
