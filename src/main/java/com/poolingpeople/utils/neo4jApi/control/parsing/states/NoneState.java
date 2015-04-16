package com.poolingpeople.utils.neo4jApi.control.parsing.states;

import com.poolingpeople.utils.neo4jApi.control.parsing.State;
import com.poolingpeople.utils.neo4jApi.control.parsing.StatementsContainer;

import javax.json.stream.JsonParser;

/**
 * Created by alacambra on 1/19/15.
 */
public class NoneState implements State {
    @Override
    public NAMES process(JsonParser parser, StatementsContainer statementsContainer) {
       throw new RuntimeException("nothing to process on state NONE");
    }

    @Override
    public NAMES getName() {
        return NAMES.NONE;
    }
}