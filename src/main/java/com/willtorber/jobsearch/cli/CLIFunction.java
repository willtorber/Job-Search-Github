package com.willtorber.jobsearch.cli;

import java.util.HashMap;
import java.util.Map;

/**
 * @author William Torres
 */
public interface CLIFunction {
    /**
     * Funcion que tomara los argumentos del CLI y los convertira en algo que se pueda
     * usar en la API de github.
     */
    static Map<String, Object> toMap(CLIArgument cliArgument) {
        Map<String, Object> params = new HashMap<>();
        params.put("description", cliArgument.getKeyword());
        params.put("location", cliArgument.getLocation());
        params.put("full_time", cliArgument.isFullTime());
        params.put("page", cliArgument.getPage());

        if (cliArgument.isMarkdown()) {
            params.put("markdown", true);
        }

        return params;
    }
}
