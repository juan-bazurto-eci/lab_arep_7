package co.edu.escuelaing.arep;

import static spark.Spark.*;

public class HelloWorldBack {
    public static void main(String[] args) {
        port(getPort());

        secure(getKeyStoreFile(), getPassword(), null, null);
        get("/hello", (req, res) -> "Hello World from HelloWorldBack");
        get("/hello-remote", (req, res) -> {
            return SecureUrlReaderBack.readSecureUrl(getDNS(), getKeyTrustFile());
        });

    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

    static String getKeyStoreFile() {
        if (System.getenv("KS") != null) {
            return System.getenv("KS");
        }
        return "keystore/ecikeystore.p12";
    }

    static String getKeyTrustFile() {
        if (System.getenv("KT") != null) {
            return System.getenv("KT");
        }
        return "keystore/ecikeystore2.p12";
    }

    static String getDNS() {
        if (System.getenv("DNS") != null) {
            return System.getenv("DNS");
        }
        return "https://localhost:5050/hello";
    }

    static String getPassword(){
        if (System.getenv("PASSWORD") != null) {
            return System.getenv("PASSWORD");
        }
        return "123456";
    }
}
