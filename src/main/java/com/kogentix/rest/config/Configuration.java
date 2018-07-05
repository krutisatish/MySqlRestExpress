package com.kogentix.rest.config;

import com.kogentix.rest.controller.Controller;
import com.strategicgains.restexpress.plugin.metrics.MetricsConfig;
import org.restexpress.RestExpress;
import org.restexpress.util.Environment;

import java.util.Properties;

public class Configuration extends Environment {
    private static final String DEFAULT_EXECUTOR_THREAD_POOL_SIZE = "20";

    private static final String PORT_PROPERTY = "port";
    private static final String BASE_URL_PROPERTY = "base.url";
    private static final String EXECUTOR_THREAD_POOL_SIZE = "executor.threadPool.size";

    private int port;
    private String baseUrl;
    private int executorThreadPoolSize;
    private MetricsConfig metricsConfig;

    private Controller controller;

    @Override
    protected void fillValues(Properties p) {
        this.port = Integer.parseInt(p.getProperty(PORT_PROPERTY, String.valueOf(RestExpress.DEFAULT_PORT)));
        this.baseUrl = p.getProperty(BASE_URL_PROPERTY, "http://localhost:" + String.valueOf(port));
        this.executorThreadPoolSize = Integer.parseInt(p.getProperty(EXECUTOR_THREAD_POOL_SIZE, DEFAULT_EXECUTOR_THREAD_POOL_SIZE));
        this.metricsConfig = new MetricsConfig(p);
        initialize();
    }

    private void initialize() {
        controller = new Controller();
    }

    public int getPort() {
        return port;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getExecutorThreadPoolSize() {
        return executorThreadPoolSize;
    }

    public MetricsConfig getMetricsConfig() {
        return metricsConfig;
    }

    public Controller getController() {
        return controller;
    }
}
