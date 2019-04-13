package com.rudysysu.sample.logging.logback;

import static net.logstash.logback.marker.Markers.append;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

public class LogbackCommon {
	private static final Logger LOG = LoggerFactory.getLogger(LogbackCommon.class);
	public LogbackCommon() {
		LOG.warn("start");
		for (int i = 0; i < 10; i++) {
			Map<String, String> meta = new HashMap<>();
			meta.put("reason", "recover data.");
			LOG.info(
					             append("privacy", "OPEN")
						    .and(append("type", "COMMON")),
					"This is a common log.");
		}
		LOG.error("end");
	}

	public static void main(String[] args) {
		SpringApplication.run(LogbackCommon.class, args);
	}

}
