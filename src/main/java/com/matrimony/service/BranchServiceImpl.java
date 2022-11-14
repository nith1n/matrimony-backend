package com.matrimony.service;

import com.matrimony.dto.BranchApproveRequestDto;
import com.matrimony.dto.BranchCreateRequestDto;
import com.matrimony.model.Branch;
import com.matrimony.model.User;
import com.matrimony.repository.BranchRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Branch createBranch(BranchCreateRequestDto branchCreateRequestDto) {
        ObjectMapper mapper = new ObjectMapper();
        branchCreateRequestDto.setCreatedOn(new Date());
        String userId = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        branchCreateRequestDto.setCreatedBy(userId);
        Branch newBranch = mapper.convertValue(branchCreateRequestDto, Branch.class);
        int seqId = sequenceGeneratorService.getSequenceNumber(Branch.SEQUENCE_NAME);
        newBranch.setId("DM22BR0" + seqId);
        return branchRepository.insert(newBranch);
    }

    @Override
    public Optional<Branch> getBranchById(String branchId) {
        return branchRepository.findById(branchId);
    }

    @Override
    public Branch approveBranch(BranchApproveRequestDto branchApproveRequestDto) {
        return null;
    }

    @Override
    public List<String> getAllBranches() {
        List<String> branchNums = new ArrayList<>();
        List<Branch> branches =  branchRepository.findAll();
        for (Branch branch : branches) {
            branchNums.add(branch.getBranchNo());
        }

        return branchNums;
    }
}
