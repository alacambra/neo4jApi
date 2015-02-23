package com.poolingpeople.utils.neo4jApi.parsing.states;

import com.poolingpeople.utils.neo4jApi.parsing.ResultContainer;
import com.poolingpeople.utils.neo4jApi.parsing.State;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.json.stream.JsonParser;

/**
 * Created by alacambra on 1/18/15.
 */
public class MainState implements State {

    NAMES readStatementResult = NAMES.READ_STATEMENT_RESULT;
    NAMES readErrors = NAMES.READ_ERRORS;

    @Override
    public NAMES process(JsonParser parser, ResultContainer resultContainer) {

        JsonParser.Event event = parser.next();

        if(event == JsonParser.Event.KEY_NAME && parser.getString().equals("results")){
            return readStatementResult;
        }

        if(event == JsonParser.Event.KEY_NAME && parser.getString().equals("errors")){
            return readErrors;
        }

        if(event == JsonParser.Event.END_OBJECT){
            return NAMES.NONE;
        }

        return this.getName();
    }

    @Override
    public NAMES getName() {
        return NAMES.MAIN_STATE;
    }
}
