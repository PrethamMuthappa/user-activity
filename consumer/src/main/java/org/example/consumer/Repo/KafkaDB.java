package org.example.consumer.Repo;

import org.example.consumer.Model.KafkaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaDB extends JpaRepository<KafkaModel,Integer> {
}
