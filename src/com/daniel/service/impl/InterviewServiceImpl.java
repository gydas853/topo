package com.daniel.service.impl;

import com.daniel.dao.InterviewMapper;
import com.daniel.model.Interview;
import com.daniel.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by nero0 on 2018-02-13.
 */
@Service("InterviewService")
public class InterviewServiceImpl implements InterviewService{

    @Resource
    private InterviewMapper interviewMapper;

    @Override
    public boolean addInterview(Interview interview) {
        return interviewMapper.addInterview(interview);
    }

    @Override
    public boolean updateInterview(Interview interview) {
        return interviewMapper.updateInterview(interview);
    }

    @Override
    public boolean deleteInterview(Interview interview) {
        return interviewMapper.deleteInterview(interview);
    }

    @Override
    public Interview getInterviewByI_id(Interview interview) {
        return interviewMapper.getInterviewByI_id(interview);
    }

    @Override
    public Interview getInterviewByI_g_id(Interview interview) {
        return interviewMapper.getInterviewByI_g_id(interview);
    }

    @Override
    public Interview getIngerviewByR_idAndG_id(Interview interview) {
        return interviewMapper.getIngerviewByR_idAndG_id(interview);
    }

    @Override
    public Interview getInterviewByI_d_id(Interview interview) {
        return interviewMapper.getInterviewByI_d_id(interview);
    }

    @Override
    public Interview getInterviewByI_p_id(Interview interview) {
        return interviewMapper.getInterviewByI_p_id(interview);
    }
}
