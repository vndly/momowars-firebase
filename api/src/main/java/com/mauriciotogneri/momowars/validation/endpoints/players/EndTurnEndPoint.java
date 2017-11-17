package com.mauriciotogneri.momowars.validation.endpoints.players;

import com.mauriciotogneri.apivalidator.api.ApiRequest;
import com.mauriciotogneri.apivalidator.api.ApiResult;
import com.mauriciotogneri.apivalidator.parameters.path.PathParameters;
import com.mauriciotogneri.momowars.api.players.EndTurn;
import com.mauriciotogneri.momowars.validation.BaseEndPoint;
import com.mauriciotogneri.momowars.validation.EndPointDefinition;

public class EndTurnEndPoint extends BaseEndPoint implements EndTurn
{
    public EndTurnEndPoint()
    {
        super(new EndPointDefinition(EndTurn.class));
    }

    public ApiResult execute(String sessionToken, String gameId, String playerId) throws Exception
    {
        PathParameter path = new PathParameter();
        path.gameId = gameId;
        path.playerId = playerId;

        ApiRequest.Builder builder = request();
        builder.header(HEADER_SESSION_TOKEN, sessionToken);
        builder.path(new PathParameters(path), PATH_FORMAT);
        builder.response(jsonResponse());

        return process(builder);
    }
}