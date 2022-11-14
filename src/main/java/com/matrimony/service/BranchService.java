package com.matrimony.service;

import com.matrimony.dto.BranchApproveRequestDto;
import com.matrimony.dto.BranchCreateRequestDto;
import com.matrimony.model.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchService {

    public Branch createBranch(BranchCreateRequestDto branchCreateRequestDto);

    public Branch approveBranch(BranchApproveRequestDto branchApproveRequestDto);

    public List<String> getAllBranches();

    public Optional<Branch> getBranchById(String id);

}
