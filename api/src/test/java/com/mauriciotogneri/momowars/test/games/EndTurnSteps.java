package com.mauriciotogneri.momowars.test.games;

import com.mauriciotogneri.apivalidator.api.ApiResult;
import com.mauriciotogneri.momowars.test.BaseSteps;

import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class EndTurnSteps extends BaseSteps
{
    @When("^I end a turn with an invalid session$")
    public void endATurnWithAnInvalidSession() throws Exception
    {
        ApiResult result = endTurnEndPoint.execute("xxx", "xxx");
        checkHttpStatus(401, result);
    }

    @When("^I end a turn with invalid parameters$")
    public void endATurnWithInvalidParameters() throws Exception
    {
        ApiResult result = endTurnEndPoint.execute("", "xxx");
        checkHttpStatus(400, result);
    }

    // TODO
    /*@When("^I end a turn on an invalid game$")
    public void endATurnOnAnInvalidGame() throws Exception
    {
        ApiResult result = endTurnEndPoint.execute(CreateSessionSteps.SESSION_TOKEN, "xxx");
        checkHttpStatus(412, result);
    }

    @When("^I end a turn on a valid game$")
    public void endATurnOnAValidGame() throws Exception
    {
        for (String gameId : ACCOUNT.games)
        {
            ApiResult result = endTurnEndPoint.execute(CreateSessionSteps.SESSION_TOKEN, gameId);
            checkHttpStatus(200, result);
        }
    }*/
}