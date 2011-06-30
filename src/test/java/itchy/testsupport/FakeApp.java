package itchy.testsupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class FakeApp {
	
	private HttpServer server;
	
	public final static String EXAMPLE_URL = "http://localhost:7070/";
	
	public void up() {
		HttpHandler handler = createHandler(htmlContent());
		server = startServer(handler);
	}
	
	private HttpHandler createHandler(final String content) {
		return new HttpHandler() {
			public void handle(HttpExchange exchange) throws IOException {
				String requestMethod = exchange.getRequestMethod();
				if (requestMethod.equalsIgnoreCase("GET")) {
					Headers responseHeaders = exchange.getResponseHeaders();
					responseHeaders.set("Content-Type", "text/html");
					exchange.sendResponseHeaders(200, 0);
					
					OutputStream responseBody = exchange.getResponseBody();
					responseBody.write(content.getBytes());
					responseBody.close();
				}
			}
		};
	}
	
	private HttpServer startServer(HttpHandler handler) {
		InetSocketAddress addr = new InetSocketAddress(7070);
		HttpServer server = null;
		try {
			server = HttpServer.create(addr, 0);
		} 
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		server.createContext("/", handler);
		server.setExecutor(Executors.newCachedThreadPool());
		server.start();
		return server; 
	}
	
	private String htmlContent() {
		try {
			this.getClass().getClassLoader();
			BufferedReader in = new BufferedReader(new InputStreamReader(
				ClassLoader.getSystemResourceAsStream("example.html")));
			StringBuilder content = new StringBuilder();
			String line = null;
			while ((line = in.readLine()) != null)
				content.append(line);
			in.close();
			return content.toString();
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void down() {
		try {
			server.stop(1);
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
