package com.herballife.main.catalog.model;

import java.sql.Blob;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Catalog {

    private int id;
    private String name;
    private String kegunaan;
    private byte[] image;

}
