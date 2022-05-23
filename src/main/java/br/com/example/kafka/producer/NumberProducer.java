package br.com.example.kafka.producer;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
public class NumberProducer {

	private final StreamBridge streamBridge;

	@Scheduled(fixedRate = 2000)
	public void publishNumbers() {
		streamBridge.send("number-0", new Random().nextInt(1000));
	}
}
