package com.poolingpeople.utils.neo4jApi.parsing.states;

import com.poolingpeople.utils.neo4jApi.parsing.ResultContainerMixed;
import com.poolingpeople.utils.neo4jApi.parsing.State;

import javax.inject.Inject;
import javax.json.stream.JsonParser;

/**
 * Created by alacambra on 1/17/15.
 */
public class ReadRow implements State {

   @Inject
   ReadColumnValue readColumnValue;

   @Inject
   ReadData readData;


    @Override
    public State process(JsonParser parser, ResultContainerMixed resultContainer) {
        JsonParser.Event event = parser.next();

        if (event == JsonParser.Event.START_ARRAY) {
            resultContainer.startNewRow();
            return readColumnValue;
        }

        if (event == JsonParser.Event.END_ARRAY || event == JsonParser.Event.END_OBJECT) {
            return readData;
        }

        throw new RuntimeException("unsupported event " + event);
    }
}
