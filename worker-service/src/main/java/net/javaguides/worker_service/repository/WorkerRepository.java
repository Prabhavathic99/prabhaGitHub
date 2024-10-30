package net.javaguides.worker_service.repository;

import net.javaguides.worker_service.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
}
