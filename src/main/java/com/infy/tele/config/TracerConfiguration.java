package com.infy.tele.service;

import java.util.regex.Pattern;

import javax.servlet.ServletContextEvent;

import org.springframework.context.annotation.Bean;

import com.uber.jaeger.Configuration;
//import com.uber.jaeger.micrometer.MicrometerMetricsFactory;
import com.uber.jaeger.samplers.ConstSampler;

import io.opentracing.Tracer;
import io.opentracing.contrib.metrics.prometheus.PrometheusMetricsReporter;

import io.prometheus.client.CollectorRegistry;

@org.springframework.context.annotation.Configuration
public class TracerConfiguration {
	
	

	@Bean
	public io.opentracing.Tracer tracer() {
		//MicrometerMetricsFactory metricsFactory1 = new MicrometerMetricsFactory();
	    Configuration configuration = new Configuration("mongosvc11");
	    Tracer tracer1 = configuration
	        .withReporter(
	            new Configuration.ReporterConfiguration()
	                .withLogSpans(true)
	        )
	        .withSampler(
	            new Configuration.SamplerConfiguration()
	                .withType(ConstSampler.TYPE)
	                .withParam(1)
	        )
	        .getTracerBuilder()
	        
	        .build();
	    
	    return io.opentracing.contrib.metrics.Metrics.decorate(
				tracer1,
				PrometheusMetricsReporter.newMetricsReporter().withCollectorRegistry(new CollectorRegistry(true))
					.withBaggageLabel("transaction","n/a")
					.build());
	}

	

	
}
