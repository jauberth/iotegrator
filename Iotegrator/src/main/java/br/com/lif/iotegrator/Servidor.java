package br.com.lif.iotegrator;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;



public class Servidor {

	public static void main(String[] args) throws IOException {
		System.out.println("Iniciando o  Iotegrator!");
		HttpServer server = startServer();
		System.out.println("Iotegrator Ready!");
		System.in.read();

		server.stop();
		
		System.out.println("Iotegrator Down!");
	}

	static HttpServer startServer() {
		System.out.println("Preparando ambiente!");
		ResourceConfig config = new ResourceConfig().packages("br.com.lif.iotegrator");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		return server;
	}

}