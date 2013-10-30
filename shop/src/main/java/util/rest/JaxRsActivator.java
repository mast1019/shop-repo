package util.rest;

import static util.Constants.REST_PATH;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath(REST_PATH)
public class JaxRsActivator extends Application {
}
