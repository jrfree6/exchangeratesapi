package exchangeratesapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY")
public class CurrencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "origin_currency")
	private String originCurrency;

	@Column(name = "destination_currency")
	private String destinationCurrency;

	@Column(name = "origin_amount")
	private double originAmount;

	@Column(name = "destination_amount")
	private double destinationAmount;

	@Column(name = "conversion_rate")
	private String conversion_rate;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "user_id")
	private String userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginCurrency() {
		return originCurrency;
	}

	public void setOriginCurrency(String originCurrency) {
		this.originCurrency = originCurrency;
	}

	public String getDestinationCurrency() {
		return destinationCurrency;
	}

	public void setDestinationCurrency(String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	public double getOriginAmount() {
		return originAmount;
	}

	public void setOriginAmount(double originAmount) {
		this.originAmount = originAmount;
	}

	public double getDestinationAmount() {
		return destinationAmount;
	}

	public void setDestinationAmount(double destinationAmount) {
		this.destinationAmount = destinationAmount;
	}

	public String getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(String conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CurrencyEntity [id=" + id + ", originCurrency=" + originCurrency + ", destinationCurrency="
				+ destinationCurrency + ", originAmount=" + originAmount + ", destinationAmount=" + destinationAmount
				+ ", conversion_rate=" + conversion_rate + ", date=" + date + ", userId=" + userId + "]";
	}
	
	

}
