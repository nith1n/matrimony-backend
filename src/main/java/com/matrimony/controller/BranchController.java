package com.matrimony.controller;

import com.matrimony.dto.BranchCreateRequestDto;
import com.matrimony.model.Branch;
import com.matrimony.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @PostMapping("/create")
    public ResponseEntity<Branch> createBranch(@RequestBody BranchCreateRequestDto branchCreateRequestDto) {
        return ResponseEntity.ok(branchService.createBranch(branchCreateRequestDto));
    }

    @GetMapping("/list")
    public List<String> getAllBranch() {
        return branchService.getAllBranches();
    }

}
