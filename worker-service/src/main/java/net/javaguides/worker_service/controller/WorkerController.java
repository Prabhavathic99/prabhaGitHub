package net.javaguides.worker_service.controller;

import lombok.AllArgsConstructor;
import net.javaguides.worker_service.dto.APIResponseDto;
import net.javaguides.worker_service.dto.WorkerDto;
import net.javaguides.worker_service.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/workers")
@AllArgsConstructor
public class WorkerController {

    private WorkerService workerService;

    // save worker detail
    @PostMapping("new")
    public ResponseEntity<WorkerDto> saveWorkerDetail(@RequestBody WorkerDto workerDto){
        WorkerDto savedWorkerDto = workerService.saveWorker(workerDto);
        return new ResponseEntity<>(savedWorkerDto, HttpStatus.CREATED);
    }

    // get worker detail
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getWorkerDetail(@PathVariable Long id){
        APIResponseDto responseDto = workerService.getWorker(id);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
