package in.vishal.service;

import in.vishal.bindings.PlanForm;

import java.util.List;

public interface PlanService {
    //taking planForm as an input and giving that data to DB and in output return t or false
    public boolean createPlan(PlanForm planForm);

    // no input only returns the created plans info
    public List<PlanForm> fetchPlans();

    public PlanForm getPlanById(Integer planId);// from DB

    public String changePlanStatus(Integer planId, String status);
    //two inputs which plan and what should be that status of that plan soft delete

}
