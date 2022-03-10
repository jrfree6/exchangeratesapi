package exchangeratesapi.dto;

public class CurrencyConvert {
	
	private String from;
	private String to;
	private double amount;
	
	public final String getFrom() {
		return from;
	}
	public final void setFrom(String from) {
		this.from = from;
	}
	public final String getTo() {
		return to;
	}
	public final void setTo(String to) {
		this.to = to;
	}
	public final double getAmount() {
		return amount;
	}
	public final void setAmount(double amount) {
		this.amount = amount;
	}

}
