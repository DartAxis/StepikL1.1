package ru.dartinc.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.dartinc.servlets.AllRequestServlet;
import ru.dartinc.servlets.MirrorServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestServlet frontend = new AllRequestServlet();
        MirrorServlet mirrorServlet = new MirrorServlet();


        Server server = new Server(8085);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);

        context.addServlet(new ServletHolder(frontend),"/*");
        context.addServlet(new ServletHolder(mirrorServlet),"/mirror");

        server.start();
        System.out.println("Server started");
        server.join();
    }
}
