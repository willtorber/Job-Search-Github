package com.willtorber.jobsearch.api;

import com.willtorber.jobsearch.vo.JobPositionVO;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * Esta interfaz sera usada por Feign para hacer las peticiones a la API de github.
 * @author William Torres
 */
@Headers("Accept: application/json")
public interface APIJob {

    @RequestLine("GET /positions.json")
    List<JobPositionVO> jobs(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /positions/{id}.json")
    JobPositionVO job(@Param("id") String id);

}
