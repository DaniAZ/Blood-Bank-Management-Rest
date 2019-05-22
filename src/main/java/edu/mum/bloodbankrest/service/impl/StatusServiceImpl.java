package edu.mum.bloodbankrest.service.impl;

import edu.mum.bloodbankrest.dao.StatusDao;
import edu.mum.bloodbankrest.domain.Status;
import edu.mum.bloodbankrest.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusDao statusDao;
    @Override
    public List<Status> findAll() {
        return statusDao.findAll();
    }
}
