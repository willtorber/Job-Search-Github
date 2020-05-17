package com.willtorber.jobsearch.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Clase que representa los resultados de una busqueda
 * @author William Torres
 */
@Data
public final class JobPositionVO {

    private String id;
    private String type;
    private String ulr;
    @SerializedName("created_at")
    private String createdAt;
    private String company;
    @SerializedName("company_url")
    private String companyUrl;
    private String location;
    private String title;
    private String description;
    @SerializedName("how_to_apply")
    private String howToApply;
    @SerializedName("company_logo")
    private String companyLogo;

}
