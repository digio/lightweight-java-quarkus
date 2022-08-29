package au.com.digio.lightweightjava.infra;

import software.amazon.awscdk.core.App;
public class InfraApp {

    public static void main(String[] args) {
        App app = new App();
        new InfraStack(app, "LightweightQuarkusStack");
        app.synth();
    }
}
