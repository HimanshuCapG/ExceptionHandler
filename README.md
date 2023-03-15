# Exception Handler

## Simple account handler implementation using factory design

| **Module**    | **Description**                                                                                    |
|---------------|----------------------------------------------------------------------------------------------------|
| client        | Client code that might generate errors which need to be handled                                    |
| actionhandler | Action handler class that will perform actions based upon the exception rasied from specific class |
| action        | Abstract action class that will be extended by each action e.g. sending sms, logging etc.          |
| actionfactory | Class to generate action object based upon exception raised from specific class                    |