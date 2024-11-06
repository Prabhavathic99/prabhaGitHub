package net.javaguides.worker_service.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.worker_service.dto.APIResponseDto;
import net.javaguides.worker_service.dto.DepartmentDto;
import net.javaguides.worker_service.dto.OrganisationDto;
import net.javaguides.worker_service.dto.WorkerDto;
import net.javaguides.worker_service.entity.Worker;
import net.javaguides.worker_service.repository.WorkerRepository;
import net.javaguides.worker_service.service.APIClient;
import net.javaguides.worker_service.service.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private WorkerRepository workerRepository;

    private RestTemplate restTemplate;

    private WebClient webClient;

    private APIClient apiClient;

    @Override
    public WorkerDto saveWorker(WorkerDto workerDto) {
        Worker worker = new Worker(
                workerDto.getId(),
                workerDto.getFirstName(),
                workerDto.getLastName(),
                workerDto.getEmail(),
                workerDto.getSalary(),
                workerDto.getDepartmentCode(),
                workerDto.getOrganisationCode()
        );
        Worker savedWorker = workerRepository.save(worker);
        WorkerDto savedWokerDto = new WorkerDto(
                savedWorker.getId(),
                savedWorker.getFirstName(),
                savedWorker.getLastName(),
                savedWorker.getEmail(),
                savedWorker.getSalary(),
                savedWorker.getDepartmentCode(),
                savedWorker.getOrganisationCode()
        );
        return savedWokerDto;
    }

    @Override
    public APIResponseDto getWorker(Long id) {

        Worker worker = workerRepository.findById(id).orElseThrow(()-> new RuntimeException("Worker Detail Not Found"));

        // ResponseEntity<DepartmentDto> departmentDto = restTemplate.getForEntity("http://localhost:8080/api/departments/" + worker.getDepartmentCode() , DepartmentDto.class);

        // DepartmentDto newDepartmentDto = departmentDto.getBody();

        /*DepartmentDto newDepartmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + worker.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

        DepartmentDto newDepartmentDto = apiClient.getDepartmentByCode(worker.getDepartmentCode());

        OrganisationDto organisationDto = webClient.get()
                .uri("http://localhost:8083/api/organisations/" + worker.getOrganisationCode())
                .retrieve()
                .bodyToMono(OrganisationDto.class)
                .block();

        //OrganisationDto organisationDto = apiClient.getOrganisationByCode(worker.getOrganisationCode());

        WorkerDto workerDto = new WorkerDto(
                worker.getId(),
                worker.getFirstName(),
                worker.getLastName(),
                worker.getEmail(),
                worker.getSalary(),
                worker.getDepartmentCode(),
                worker.getOrganisationCode()
        );

        APIResponseDto response = new APIResponseDto();
        response.setWorkerDto(workerDto);
        response.setDepartmentDto(newDepartmentDto);
        response.setOrganisationDto(organisationDto);

        return response;
    }
}
