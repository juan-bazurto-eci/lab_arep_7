package co.edu.escuelaing.arep;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        port(getPort());
        secure("keystore/ecikeystore2.p12", "123456", null, null);
        get("/hello", (req, res) -> "Hello World");
        get("/hello-remote", (req, res) -> {
            return SecureUrlReaderBack.readSecureUrl("https://localhost:5000/hello","keystore/ecikeystore.p12");
        });
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5050; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
