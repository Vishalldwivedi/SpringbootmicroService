package in.vishal.service;

import in.vishal.bindings.PlanForm;
import in.vishal.bindings.UserAccForm;
import in.vishal.entity.PlanEntity;
import in.vishal.entity.UserEntity;
import in.vishal.repositories.PlanRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService{
    @Autowired
    private PlanRepo planRepo;

    @Override
    public boolean createPlan(PlanForm planForm) {
        PlanEntity planEntity = new PlanEntity();
        BeanUtils.copyProperties(planForm,planEntity);

        planRepo.save(planEntity);

return true;
    }

    @Override
    public List<PlanForm> fetchPlans() {
       List<PlanEntity> planEntities=  planRepo.findAll();

       List<PlanForm> plans = new ArrayList<>();
       for(PlanEntity planEntity:planEntities){
           PlanForm planForm = new PlanForm();
           BeanUtils.copyProperties(planEntity , planForm);
           plans.add(planForm);
       }
       return plans;
    }

    @Override
    public PlanForm getPlanById(Integer planId) {
        Optional<PlanEntity> optional = planRepo.findById(planId);

        if(optional.isPresent()){
            PlanEntity planEntity = optional.get();
            //but we need the binding PlanForm in the UI
            PlanForm plan  = new PlanForm();
            BeanUtils.copyProperties(planEntity,plan);//user entity to user binding object
            return plan;
        }
        return null;
    }

    @Override
    public String changePlanStatus(Integer planId, String status) {
        int count = planRepo.updatePlanStatus(planId,status);
        if(count>0){
            return "Status Changed";
        }else{
            return "Failed to Change";
        }
    }
}
