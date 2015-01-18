package com.poolingpeople.utils.neo4jApi.parsing.states;

import com.poolingpeople.utils.neo4jApi.parsing.ResultContainerMixed;
import com.poolingpeople.utils.neo4jApi.parsing.State;

import javax.inject.Inject;
import javax.json.stream.JsonParser;

/**
 * Created by alacambra on 1/18/15.
 */
public class ReadErrors implements State{

    @Inject
    ReadError readError = new ReadError();

    @Inject
    MainState mainState = new MainState();

    @Override
    public State process(JsonParser parser, ResultContainerMixed resultContainer) {

        JsonParser.Event event = parser.next();

        if(event == JsonParser.Event.START_ARRAY){
             return readError;
        }

        if(event == JsonParser.Event.END_ARRAY){
            return mainState;
        }

        throw new RuntimeException("Unexpceted event " + event);
    }
}
