package serveur;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServeur implements AppServeur {

    private Tomcat tomcat;
    public static final int PORT = 8888;
    public static final String  WEB_DIR  = "app/src/webapp/";
    public static final String APP_BASE_URL = "";
    public static final String OUTPUT_DIR = "app/out/production/classes";
    public static final String WEB_APP_MOUNT_DIR = "/WEB-INF/classes";
    public static final String BASE_PATH = "/";

    @Override
    public void create() {
        System.setProperty("tomcat.util.scan.StandardJarScanFilter.jarsToSkip", "*.jar");
        tomcat = new Tomcat();
    }

    @Override
    public void configure() {
        tomcat.setPort(this.PORT);
        try {

            Context context = tomcat.addWebapp(APP_BASE_URL,new File( WEB_DIR ).getAbsolutePath());
            File classDir = new File(OUTPUT_DIR);
            WebResourceRoot resourceRoot = new StandardRoot(context);
            resourceRoot.addPreResources(new DirResourceSet(resourceRoot,WEB_APP_MOUNT_DIR,classDir.getAbsolutePath(), BASE_PATH ));
            context.setResources(resourceRoot);

        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {

            tomcat.getConnector();
            tomcat.start();
            tomcat.getServer().await();

        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            tomcat.stop();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
