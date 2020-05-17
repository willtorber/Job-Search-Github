package com.willtorber.jobsearch;

import com.beust.jcommander.JCommander;
import com.willtorber.jobsearch.api.APIJob;
import com.willtorber.jobsearch.cli.CLIArgument;
import com.willtorber.jobsearch.cli.CLIFunction;
import com.willtorber.jobsearch.vo.JobPositionVO;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.willtorber.jobsearch.CommanderFunction.buildCommanderWithName;
import static com.willtorber.jobsearch.CommanderFunction.parseArguments;
import static com.willtorber.jobsearch.api.APIFunction.buildAPI;

public class JobSearch {

    public static void main(String[] args) {

        //Creacion de nuestro CLI con JCommander
        JCommander jCommander = buildCommanderWithName("job-search", CLIArgument::newInstance);

        //Obtenemos las opciones que se le dieron a JCommander
        Stream<CLIArgument> cliArgumentStream =
                //Nos retorna un Optional<List<Object>>
                parseArguments(jCommander, args, JCommander::usage)
                        //En caso de un Optional.empty()
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArgument) obj);

        //Tomamos nuestro Stream y obtenemos las opciones que se dieron en el CLI
        Optional<CLIArgument> optionalCLIArgument = cliArgumentStream
                //Solo nos interesan los casos donde no sea la solicitud de ayuda
                .filter(cli -> !cli.isHelp())
                //Y que contengan un keyword, en otros caso no tenemos que buscar
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        //Si el Optional tiene un dato, lo convertimos a Map<String,Object>
        optionalCLIArgument.map(CLIFunction::toMap)
                //Convertimos el Map en un request
                .map(JobSearch::executeRequest)
                //Aun seguimos operando sobre un Optional… en caso de que no hubiera datos
                //Generamos un stream vacio
                .orElse(Stream.empty())
                //Imprimos los datos por pantalla.
                .forEach(System.out::println);

    }

    private static Stream<JobPositionVO> executeRequest(Map<String, Object> options) {
        APIJob api = buildAPI(APIJob.class, "https://jobs.github.com");

        return Stream.of(options)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}