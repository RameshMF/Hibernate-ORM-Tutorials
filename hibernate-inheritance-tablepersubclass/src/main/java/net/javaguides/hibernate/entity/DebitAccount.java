package net.javaguides.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="DebitAccount")
@PrimaryKeyJoinColumn(name = "account_id")
public class DebitAccount extends Account {

	private double overdraftFee;

	public double getOverdraftFee() {
		return overdraftFee;
	}

	public void setOverdraftFee(double overdraftFee) {
		this.overdraftFee = overdraftFee;
	}
}