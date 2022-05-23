package br.com.example.kafka.stream;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static org.springframework.kafka.support.KafkaHeaders.MESSAGE_KEY;

@Component("evenOddNumberProcessor")
public class evenOddNumberProcessor implements Function<Integer, Message<String>> {

	@Override
	public Message<String> apply(Integer number) {
		var evenOrOdd = "Odd";

		if (number % 2 == 0) {
			evenOrOdd = "Even";
		}
		System.out.println(String.format("Number: %s | %s", number, evenOrOdd));
		return MessageBuilder.withPayload(evenOrOdd).setHeader(MESSAGE_KEY, number.toString()).build();
	}
}
