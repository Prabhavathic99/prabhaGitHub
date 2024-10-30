package net.javaguides.worker_service.service;

import net.javaguides.worker_service.dto.APIResponseDto;
import net.javaguides.worker_service.dto.WorkerDto;

public interface WorkerService {

    WorkerDto saveWorker(WorkerDto workerDto);

    APIResponseDto getWorker(Long id);

}
