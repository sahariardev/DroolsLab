package com.ngfs.ruleengine.helper;

import java.io.File;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;

import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ngfs.ruleengine.model.Result;

public class FireRuleBean {
 
    
    private KieSession createSession() {
        
        File file = new File("/home/sahariar/Codes/files/rule.drl");
        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();
        KieRepository kr = ks.getRepository();
        Resource resource = ks.getResources().newFileSystemResource(file).setResourceType(ResourceType.DRL);
        kfs.write(resource);
        KieBuilder kb = ks.newKieBuilder(kfs);
        kb.buildAll();
        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
        KieSession kSession = kContainer.newKieSession();
        
        return kSession;
    }
    
    public Result fireRules() {
        
    	KieSession kSession= createSession();
        Result result= new Result();
        result.setIsRuleHit(false);
        kSession.setGlobal("result", result);
        
        
        /*for(Customer customer : customers){
            kSession.insert(customer);
        }
        for(MasterCard masterCard : masterCards){
            kSession.insert(masterCard);
        }
        for(SupplimentCard supplimentCard : supplimentCards){
            kSession.insert(supplimentCard);
        }*/
        
        kSession.fireAllRules();
        
        Result x =(Result) kSession.getGlobal("result");
        System.out.println(x.getIsRuleHit());
        System.out.println(x.getName());
        
        kSession.dispose();
        return x;
    }
       public Result fireRules(Object o) {
        
    	KieSession kSession= createSession();
        Result result= new Result();
        result.setIsRuleHit(false);
        kSession.setGlobal("result", result);
        kSession.insert(o);
        
        /*for(Customer customer : customers){
            kSession.insert(customer);
        }
        for(MasterCard masterCard : masterCards){
            kSession.insert(masterCard);
        }
        for(SupplimentCard supplimentCard : supplimentCards){
            kSession.insert(supplimentCard);
        }*/
        
        kSession.fireAllRules();
        
        Result x =(Result) kSession.getGlobal("result");
        System.out.println(x.getIsRuleHit());
        System.out.println(x.getName());
        
        kSession.dispose();
        return x;
    }
}