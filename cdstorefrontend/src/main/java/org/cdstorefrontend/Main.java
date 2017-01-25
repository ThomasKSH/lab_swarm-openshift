package org.cdstorefrontend;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.undertow.WARArchive;

public class Main {
    public static void main(String... args) throws Exception {
        Container container = new Container();
        container.start();

        WARArchive war = ShrinkWrap.create(WARArchive.class);
        war.staticContent();
        war.addAllDependencies();
        war.addModule("org.wildfly.swarm.container");
        container.deploy(war);
    }
}