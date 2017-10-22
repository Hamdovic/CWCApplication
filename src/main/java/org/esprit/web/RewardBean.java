package org.esprit.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import org.esprit.domain.Reward;
import org.esprit.business.RewardServiceLocal;



@ManagedBean
@ViewScoped
public class RewardBean {
	
	@EJB
    private RewardServiceLocal rewardServiceLocal;
	private Reward reward = new Reward();
	List<Reward> rewards ;
	
	public RewardBean() {
		
	}

	@PostConstruct
	public void init() {
		rewards = rewardServiceLocal.findAllRewList();
	}
	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

}
