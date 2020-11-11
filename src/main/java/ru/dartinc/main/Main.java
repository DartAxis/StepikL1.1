package ru.dartinc.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.dartinc.servlets.AllRequestServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestServlet frontend = new AllRequestServlet();
        Server server = new Server(8085);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(frontend),"/*");
        server.start();
        server.join();
    }
}
