The project flow begins at startup, where Spring Boot evaluates the `spring.profiles.active` property 
to determine the environment. Based on this, the Configuration Layer selectively instantiates a seasonal bean, 
injecting the specific message from the corresponding `.properties` file into the `GreetingService`. 
When a client sends a request to the `/weather` endpoint, it first clears the **Security Filter Chain**,
which permits public access. The `Controller` then receives the request and calls the injected service to retrieve
the seasonal greeting, wrapping the result in a `WeatherResponse` record. Finally, 
this data is serialized into a JSON object and delivered back to the client as a clean, structured response.
