package com.willtorber.jobsearch.cli;

import com.beust.jcommander.Parameter;
import com.willtorber.jobsearch.cli.validator.CLIHelpValidator;
import com.willtorber.jobsearch.cli.validator.CLIKeywordValidator;
import lombok.Data;

@Data
public final class CLIArgument {
    /**
     * Constructor default para permitir que solo clases en el paquete, puedan crear objetos
     * de esta clase.
     * De esta manera obligamos a que la construccion se haga mediante funciones publicas o
     * builders.
     * <p>
     * Las instancias deberan crearse mediante: CLIArguments#newInstance
     */
    CLIArgument() {
    }

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD",
            validateWith = CLIKeywordValidator.class)
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "Ciudad, codigo postal o algun otro termino para buscar una ubicacion")
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "Cada busqueda contiene 50 posiciones, puedes paginar mas resultados cambiando el numero, la paginacion empieza en 0")
    private int page = 0;

    @Parameter(
            names = "--full-time",
            description = "Agregar esta bandera si se desea unicamente listar trabajos de 'full time'"
    )
    private boolean isFullTime = false;

    @Parameter(
            names = "--markdown",
            description = "Agregar esta bandera si se desea obtener los resultados en markdown"
    )
    private boolean isMarkdown = false;

    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Muestra esta ayuda")
    private boolean help;

    /**
     * Esta funcion es equivalente a CLIArguments::new, sin embargo, si en el futuro queremos agregar
     * parametros adicionales, podemos limitar la manera de construir objetos mediante esta funcion.
     */
    public static CLIArgument newInstance() {
        return new CLIArgument();
    }
}
