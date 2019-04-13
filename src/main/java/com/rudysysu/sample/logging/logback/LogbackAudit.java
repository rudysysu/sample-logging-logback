package com.rudysysu.sample.logging.logback;

import static net.logstash.logback.marker.Markers.append;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogbackAudit {
	private static final Logger LOG = LoggerFactory.getLogger(LogbackAudit.class);

	public LogbackAudit() {

		LOG.warn("start");
		for (int i = 0; i < 10; i++) {
			Map<String, String> meta = new HashMap<>();
			meta.put("reason", "recover data.");
			LOG.info(
					             append("privacy", "PRIVATE")
						    .and(append("type", "AUDIT"))
						    .and(append("actorId", "a8098c1a-f86e-11da-bd1a-00112444be1e"))
							.and(append("subjectType", "VEHICLE"))
							.and(append("action", "CREATE"))
							.and(append("actionResult", "SUCCESS")),
					"");
		}
		LOG.error("end");
	}

	public static void main(String[] args) {
		SpringApplication.run(LogbackAudit.class, args);
	}
}
