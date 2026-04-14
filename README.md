The project flow begins at startup, where Spring Boot evaluates the `spring.profiles.active` property
to determine the environment. Based on this, the Configuration Layer selectively instantiates a seasonal bean,
injecting the specific message from the corresponding `.properties` file into the `GreetingService`.
When a client sends a request to the `/weather` endpoint, it first clears the **Security Filter Chain**,
which permits public access. The `Controller` then receives the request and calls the injected service to retrieve
the seasonal greeting, wrapping the result in a `WeatherResponse` record. Finally,
this data is serialized into a JSON object and delivered back to the client as a clean, structured response.

## 📦 Distribution & Releases
The latest stable version of this application is available in the [Releases](https://github.com/FatemaTujZohra20/Java_SpringBoot_Ostad_Batch03_Module18_Assignment/releases/tag/v1.0.0) section.

### Current Version: `v1.0.0-GA`
- **Artifact:** `weather_message_app-0.0.1-SNAPSHOT.jar`
- **Build Status:** ![Passing](https://img.shields.io/badge/build-passing-brightgreen)
- **Release Type:** Stable (General Availability)

### 🏃 Running the Application (From Project Root)

Once the build is successful, the executable JAR file is generated inside the `target/` directory. 
Use the following command in your terminal to start the application with the **summer** or **winter** profile active:

```bash
java -jar -Dspring.profiles.active=summer target/weather_message_app-0.0.1-SNAPSHOT.jar
```
```bash
java -jar -Dspring.profiles.active=winter target/weather_message_app-0.0.1-SNAPSHOT.jar
```
