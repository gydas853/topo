package com.daniel.service;

import com.daniel.model.Interview;

/**
 * Created by nero0 on 2018-02-13.
 */
public interface InterviewService {
    boolean addInterview(Interview interview);
    boolean updateInterview(Interview interview);
    boolean deleteInterview(Interview interview);
    Interview getInterviewByI_id(Interview interview);
    Interview getInterviewByI_g_id(Interview interview);
    Interview getIngerviewByR_idAndG_id(Interview interview);
    Interview getInterviewByI_d_id(Interview interview);
    Interview getInterviewByI_p_id(Interview interview);
}
